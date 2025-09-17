package com.example.Aug19_SpringBootApplication.service;

import com.example.Aug19_SpringBootApplication.component.SaveToBothDbs;
import com.example.Aug19_SpringBootApplication.dtos.Response;
import com.example.Aug19_SpringBootApplication.entities.AadhaarRecord;
import com.example.Aug19_SpringBootApplication.entities.DocumentRecord;
import com.example.Aug19_SpringBootApplication.exception.BadRequestException;
import com.example.Aug19_SpringBootApplication.service.reader.*;
import com.example.Aug19_SpringBootApplication.service.util.AadhaarParsers;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.*;

@Service
@RequiredArgsConstructor
public class FileIngestService {

    private final ExcelReader excelReader;
    private final PdfReader pdfReader;
    private final ImageOcrReader imageOcrReader;
    private final SaveToBothDbs saver;

    public Response ingest(MultipartFile file) throws Exception {
        if (file == null || file.isEmpty()) throw new BadRequestException("File is required");
        String type = Optional.ofNullable(file.getContentType()).orElse("");
        String name = file.getOriginalFilename();

        if (isExcel(type, name)) {
            var table = excelReader.read(file);
            String preview = preview(table);
            DocumentRecord doc = SaveToBothDbs.newDoc(name, "excel", "EXTRACTED",
                    "Rows: " + table.size());
            Long mysqlId = saver.saveMysql(doc);
            Long oracleId = saver.saveOracle(doc);
            return Response.builder()
                    .message("Excel extracted & saved successfully")
                    .fileName(name).contentType(type)
                    .highlights(List.of(preview))
                    .mysqlId(mysqlId).oracleId(oracleId).build();

        } else if (isPdf(type, name)) {
            var table = pdfReader.readTables(file);
            String preview = preview(table);
            DocumentRecord doc = SaveToBothDbs.newDoc(name, "pdf", "EXTRACTED",
                    "Rows: " + table.size());
            Long mysqlId = saver.saveMysql(doc);
            Long oracleId = saver.saveOracle(doc);
            return Response.builder()
                    .message("PDF tables extracted & saved successfully")
                    .fileName(name).contentType(type)
                    .highlights(List.of(preview))
                    .mysqlId(mysqlId).oracleId(oracleId).build();

        } else if (isImage(type, name)) {
            String ocr = imageOcrReader.ocr(file);
            Map<String,String> parsed = AadhaarParsers.parseFromOcr(ocr);

            DocumentRecord doc = SaveToBothDbs.newDoc(name, "image", "EXTRACTED",
                    "OCR length: " + ocr.length());
            Long mysqlDoc = saver.saveMysql(doc);
            Long oracleDoc = saver.saveOracle(doc);

            Long mysqlA = null, oracleA = null;
            if (!parsed.isEmpty()) {
                AadhaarRecord ar = AadhaarRecord.builder()
                        .name(parsed.get("name"))
                        .dob(parsed.get("dob"))
                        .gender(parsed.getOrDefault("gender",""))
                        .address(parsed.get("address"))
                        .aadhaarNumber(parsed.get("aadhaarNumber"))
                        .sourceFile(name)
                        .build();
                mysqlA = saver.saveMysql(ar);
                oracleA = saver.saveOracle(ar);
            }
            return Response.builder()
                    .message("Image OCR extracted & saved successfully")
                    .fileName(name).contentType(type)
                    .highlights(new ArrayList<>(parsed.values()))
                    .mysqlId(mysqlA != null ? mysqlA : mysqlDoc)
                    .oracleId(oracleA != null ? oracleA : oracleDoc)
                    .build();

        } else {
            throw new BadRequestException("Unsupported file type: " + type);
        }
    }

    private static boolean isExcel(String ct, String name) {
        return (MediaType.APPLICATION_OCTET_STREAM_VALUE.equals(ct) && name != null && name.matches(".*\\.(?i)(xls|xlsx)$"))
                || (ct != null && (ct.contains("application/vnd.ms-excel")
                || ct.contains("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet")));
    }
    private static boolean isPdf(String ct, String name) {
        return (ct != null && ct.equalsIgnoreCase(MediaType.APPLICATION_PDF_VALUE))
                || (name != null && name.toLowerCase().endsWith(".pdf"));
    }
    private static boolean isImage(String ct, String name) {
        return (ct != null && ct.startsWith("image/"))
                || (name != null && name.toLowerCase().matches(".*\\.(jpg|jpeg|png|webp)$"));
    }
    private static String preview(List<List<String>> table) {
        if (table.isEmpty()) return "(no rows)";
        return String.join(" | ", table.get(Math.min(1, table.size()-1)));
    }
}
