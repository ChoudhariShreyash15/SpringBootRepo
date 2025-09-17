package com.example.SpringBoot1.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Bank {

    @Id
    @SequenceGenerator(name = "bank_seq",initialValue = 1,allocationSize = 20)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "bank_seq")
    private int id;
    private String name;
    private int accNo;
    private String custName;
    private double balance;
}
