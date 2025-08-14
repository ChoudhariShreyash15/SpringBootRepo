package com.example.Aug12_SpringOCR.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AadharCard {

    @Id
    private Long aadharNo;
    private String name;
    private String dob;
    private String gender;
    private String address;
}
