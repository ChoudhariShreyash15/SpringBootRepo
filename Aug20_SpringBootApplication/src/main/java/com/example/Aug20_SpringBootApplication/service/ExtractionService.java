package com.example.Aug20_SpringBootApplication.service;

import com.example.Aug20_SpringBootApplication.mysqlEntity.MysqlTableRow;
import com.example.Aug20_SpringBootApplication.mysqlRepo.MysqlTableRepo;
import com.example.Aug20_SpringBootApplication.oracleEntity.OracleTableRow;
import com.example.Aug20_SpringBootApplication.oracleRepo.OracleTableRepo;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.rendering.PDFRenderer;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.usermodel.Cell;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import technology.tabula.*;
import technology.tabula.Table;
import technology.tabula.extractors.SpreadsheetExtractionAlgorithm;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.file.*;
import java.util.*;

@Service
public class ExtractionService {

    @Autowired
    private MysqlTableRepo mysqlRepo;

    @Autowired
    private OracleTableRepo oracleRepo;

    // Save row to both DBs
    private void saveRow(String name, Long age, String department) {
        mysqlRepo.save(new MysqlTableRow(null, name, age, department));
        oracleRepo.save(new OracleTableRow(null, name, age, department));
    }

    // 1. PDF Table Reader
    public void readPdfTables(MultipartFile multipartFile) {
        try (PDDocument pdDocument = PDDocument.load(multipartFile.getInputStream())) {
            ObjectExtractor objectExtractor = new ObjectExtractor(pdDocument);
            SpreadsheetExtractionAlgorithm bea = new SpreadsheetExtractionAlgorithm();
            PageIterator extract = objectExtractor.extract();

            while (extract.hasNext()) {
                Page page = extract.next();
                List<Table> tables = bea.extract(page);

                for (Table table : tables) {
                    for (List<RectangularTextContainer> row : table.getRows()) {
                        // Collect row values
                        List<String> values = new ArrayList<>();
                        for (RectangularTextContainer cell : row) {
                            values.add(cell.getText().trim());
                        }

                        // Skip header row (optional)
                        if (values.get(0).equalsIgnoreCase("id")) continue;

                        // Map to entity (assuming format: ID | Name | Age | Department)
                        if (values.size() >= 4) {
                            OracleTableRow entity = new OracleTableRow();
                            entity.setName(values.get(1));
                            entity.setAge(parseAge(values.get(2)));
                            entity.setDepartment(values.get(3));
                            oracleRepo.save(entity);  // save to Oracle (if you have oracleRepo)
                        }
                    }
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("Error while reading PDF tables", e);
        }
    }

    // ---- EXCEL READER ----
    public void readExcel(MultipartFile multipartFile) {
        try (InputStream inputStream = multipartFile.getInputStream();
             Workbook workbook = WorkbookFactory.create(inputStream)) {

            DataFormatter dataFormatter = new DataFormatter();
            Sheet sheetAt = workbook.getSheetAt(0);
            Iterator<Row> iterator = sheetAt.iterator();

            boolean isHeader = true;
            while (iterator.hasNext()) {
                Row row = iterator.next();

                // Skip first header row
                if (isHeader) {
                    isHeader = false;
                    continue;
                }

                String name = dataFormatter.formatCellValue(row.getCell(1));
                String ageStr = dataFormatter.formatCellValue(row.getCell(2));
                String department = dataFormatter.formatCellValue(row.getCell(3));

                OracleTableRow entity = new OracleTableRow();
                entity.setName(name);
                entity.setAge(parseAge(ageStr));
                entity.setDepartment(department);
                oracleRepo.save(entity);
            }
        } catch (Exception e) {
            throw new RuntimeException("Error while reading Excel file", e);
        }
    }

    // ---- HELPER ----
    private Long parseAge(String value) {
        try {
            return Long.parseLong(value.trim());
        } catch (Exception e) {
            return null; // or 0L if you want default
        }
    }

    // 3. PDF Text Reader (non-tabular)
    public void readPdfText(MultipartFile multipartFile) {
        try (PDDocument document = PDDocument.load(multipartFile.getInputStream())) {
            PDFTextStripper pdfTextStripper = new PDFTextStripper();
            String text = pdfTextStripper.getText(document);
            System.out.println("----- Extracted PDF Text -----");
            System.out.println(text);
        } catch (Exception e) {
            throw new RuntimeException("Error while reading PDF text", e);
        }
    }

    // 4. OCR (image or scanned PDF)
    public void processOcr(MultipartFile multipartFile) throws IOException, TesseractException {
        Tesseract tesseract = new Tesseract();
        tesseract.setDatapath("C:\\Program Files\\Tesseract-OCR\\tessdata");
        tesseract.setLanguage("eng");

        if (multipartFile.getContentType() != null) {
            if (multipartFile.getContentType().startsWith("image/")) {
                processImage(multipartFile, tesseract);
            } else if (multipartFile.getContentType().equals("application/pdf")) {
                processPdf(multipartFile, tesseract);
            }
        }
    }

    private void processImage(MultipartFile multipartFile, Tesseract tesseract) throws IOException, TesseractException {
        Path path = Files.createTempFile("ocr-", extract(multipartFile.getOriginalFilename()));
        Files.copy(multipartFile.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);

        BufferedImage bufferedImage = ImageIO.read(path.toFile());
        String s = tesseract.doOCR(bufferedImage);
        System.out.println("----- OCR Image Result -----");
        System.out.println(s);
    }

    private void processPdf(MultipartFile multipartFile, Tesseract tesseract) throws IOException, TesseractException {
        Path path = Files.createTempFile("pdf-", extract(multipartFile.getOriginalFilename()));
        Files.copy(multipartFile.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);

        PDDocument pdDocument = PDDocument.load(path.toFile());
        PDFRenderer pdfRenderer = new PDFRenderer(pdDocument);

        for (int page = 0; page < pdDocument.getNumberOfPages(); page++) {
            BufferedImage bufferedImage = pdfRenderer.renderImageWithDPI(page, 300);
            String s = tesseract.doOCR(bufferedImage);
            System.out.println("----- OCR PDF Page " + page + " Result -----");
            System.out.println(s);
        }

        pdDocument.close();
    }

    private String extract(String filename) {
        return filename.substring(filename.lastIndexOf('.'));
    }
}
