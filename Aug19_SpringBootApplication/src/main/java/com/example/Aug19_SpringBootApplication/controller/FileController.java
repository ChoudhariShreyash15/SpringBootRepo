package com.example.Aug19_SpringBootApplication.controller;

import com.example.Aug19_SpringBootApplication.dtos.Response;
import com.example.Aug19_SpringBootApplication.service.FileIngestService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/files")
public class FileController {

    private final FileIngestService service;

    @PostMapping(value="/ingest", consumes = {"multipart/form-data"})
    @Operation(summary = "Upload a file (.jpg/.webp/.pdf/.xls/.xlsx) and save extracted data to MySQL & Oracle")
    public ResponseEntity<Response> ingest(@RequestPart("file") MultipartFile file) throws Exception {
        return ResponseEntity.ok(service.ingest(file));
    }
}

