package com.example.Aug13_SpringPdf_Image_Reader.controller;

import com.example.Aug13_SpringPdf_Image_Reader.service.serviceOcr;
import net.sourceforge.tess4j.TesseractException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
public class controllerOcr {

    @Autowired
    private serviceOcr serviceOcr;

    @GetMapping("/image")
    public ResponseEntity<String> handleOcr(@RequestParam MultipartFile multipartFile)
            throws TesseractException, IOException {
        serviceOcr.readOcr(multipartFile);
        return ResponseEntity.ok("Image Extracted Successfully");
    }

    @GetMapping("/pdf")
    public ResponseEntity<String> readFile(@RequestParam MultipartFile multipartFile)
            throws IOException, TesseractException {
        serviceOcr.processFile(multipartFile);
        return ResponseEntity.ok("PDF Extracted Successfully");
    }
}
