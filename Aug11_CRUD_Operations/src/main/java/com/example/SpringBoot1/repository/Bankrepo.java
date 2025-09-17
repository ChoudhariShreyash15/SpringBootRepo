package com.example.SpringBoot1.repository;

import com.example.SpringBoot1.entity.Bank;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface Bankrepo extends JpaRepository<Bank,Integer> {

    Optional<Bank> findByName(String name);
}
