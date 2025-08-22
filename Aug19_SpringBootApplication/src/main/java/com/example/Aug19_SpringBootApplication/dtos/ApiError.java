package com.example.Aug19_SpringBootApplication.dtos;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ApiError {
    private String error;
    private String details;
}

