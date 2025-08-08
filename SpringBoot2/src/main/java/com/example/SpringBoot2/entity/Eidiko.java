package com.example.SpringBoot2.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.Query;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
//@Table(name = "Company")
public class Eidiko {

    @Id
    private int empId;
    private String empName;
    private String dept;
    private double empSalary;
}
