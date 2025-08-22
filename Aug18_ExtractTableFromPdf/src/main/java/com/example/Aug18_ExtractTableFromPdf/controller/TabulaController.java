package com.example.Aug18_ExtractTableFromPdf.controller;

import com.example.Aug18_ExtractTableFromPdf.service.TabulaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
//@RequestMapping("/tabula")
public class TabulaController {

    @Autowired
    private TabulaService tabulaService;

    @PostMapping("/pdf")
    public ResponseEntity<String> readPdf(@RequestParam MultipartFile file) {
        tabulaService.readPdf(file);
        return ResponseEntity.ok("PDF processed successfully");
    }

    @PostMapping("/excel")
    public ResponseEntity<String> readExcel(@RequestParam MultipartFile file) {
        tabulaService.readExcel(file);
        return ResponseEntity.ok("Excel processed successfully");
    }
}

