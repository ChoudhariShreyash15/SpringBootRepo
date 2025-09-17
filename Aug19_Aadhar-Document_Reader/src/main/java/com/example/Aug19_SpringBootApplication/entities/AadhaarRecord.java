package com.example.Aug19_SpringBootApplication.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="aadhaar_record")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AadhaarRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String dob;      // keep as String because OCR quirks; normalize if you like
    private String gender;
    private String address;
    private String aadhaarNumber; // 12 digits (no spaces)
    private String sourceFile;
}





