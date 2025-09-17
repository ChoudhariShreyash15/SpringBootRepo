package com.example.Aug19_SpringBootApplication.config;

import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {
    @Bean
    public OpenAPI api() {
        return new OpenAPI().info(new Info()
                .title("Multi File Ingest API")
                .description("Read JPG/WEBP/PDF/XLS/XLSX, extract & store to MySQL + Oracle")
                .version("v1"));
    }
}

