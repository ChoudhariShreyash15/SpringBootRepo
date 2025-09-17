package com.example.SpringBootMapping.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {

    @Id
    @SequenceGenerator(name = "address-seq", allocationSize = 20)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "address_seq")
    private int id;
    private String city;
    private String state;
}
