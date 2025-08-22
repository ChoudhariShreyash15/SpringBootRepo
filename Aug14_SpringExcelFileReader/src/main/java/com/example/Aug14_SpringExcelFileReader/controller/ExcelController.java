package com.example.Aug14_SpringExcelFileReader.controller;

import com.example.Aug14_SpringExcelFileReader.service.ExcelService;
import net.sourceforge.tess4j.TesseractException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
public class ExcelController {
    @Autowired
    private ExcelService excelService;

    @GetMapping("/test")
    public void testOCR(@RequestParam MultipartFile multipartFile) throws TesseractException, IOException {
        excelService.testOCR(multipartFile);
    }


    //advance way to handel the multipart files and for pdf add dependency
    @GetMapping("/test2")
    public void advwayOCR(@RequestParam MultipartFile multipartFile) throws IOException, TesseractException {
        excelService.advwayOCR(multipartFile);
    }


}

