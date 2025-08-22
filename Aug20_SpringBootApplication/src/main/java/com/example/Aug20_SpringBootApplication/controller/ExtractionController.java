package com.example.Aug20_SpringBootApplication.controller;

import com.example.Aug20_SpringBootApplication.service.ExtractionService;
import net.sourceforge.tess4j.TesseractException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
//@RequestMapping("/extract")
public class ExtractionController {

    @Autowired
    private ExtractionService extractionService;

    // PDF Tables → store in DBs
    @PostMapping("/pdf/tables")
    public ResponseEntity<String> readPdfTables(@RequestParam MultipartFile file) {
        extractionService.readPdfTables(file);
        return ResponseEntity.ok("PDF tables extracted & stored in MySQL + Oracle");
    }

    // Excel → store in DBs
    @PostMapping("/excel")
    public ResponseEntity<String> readExcel(@RequestParam MultipartFile file) {
        extractionService.readExcel(file);
        return ResponseEntity.ok("Excel extracted & stored in MySQL + Oracle");
    }

    // PDF Full Text (not tables)
    @PostMapping("/pdf/text")
    public ResponseEntity<String> readPdfText(@RequestParam MultipartFile file) {
        extractionService.readPdfText(file);
        return ResponseEntity.ok("PDF text extracted successfully");
    }

    // OCR (Image or Scanned PDF)
    @PostMapping("/ocr")
    public ResponseEntity<String> processOcr(@RequestParam MultipartFile file) throws IOException, TesseractException {
        extractionService.processOcr(file);
        return ResponseEntity.ok("OCR processed successfully");
    }
}
