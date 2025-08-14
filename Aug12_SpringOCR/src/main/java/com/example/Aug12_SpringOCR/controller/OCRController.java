package com.example.Aug12_SpringOCR.controller;

import com.example.Aug12_SpringOCR.service.OCRService;
import net.sourceforge.tess4j.TesseractException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
public class OCRController {

    @Autowired
    private OCRService ocrService;

    @GetMapping("/ocr")
    public ResponseEntity<String> ocrService(@RequestParam MultipartFile multipartFile) throws IOException, TesseractException {
        ocrService.readOcr(multipartFile);

        return ResponseEntity.ok("Data Read Successfully");
    }
}
