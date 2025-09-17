package com.example.Aug19_SpringBootApplication.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Response {
    private String message;      // e.g., "Data extracted & saved successfully"
    private String fileName;
    private String contentType;
    private List<String> highlights;  // few extracted bits
    private Long mysqlId;
    private Long oracleId;
}

