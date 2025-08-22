package com.example.Aug19_SpringBootApplication.entities;

import jakarta.persistence.*;
import lombok.*;
import java.time.Instant;

@Entity
@Table(name="document_record")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DocumentRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fileName;
    private String contentType;
    private String status;       // EXTRACTED / FAILED
    private String summary;      // short message
    private Instant createdAt;
}

