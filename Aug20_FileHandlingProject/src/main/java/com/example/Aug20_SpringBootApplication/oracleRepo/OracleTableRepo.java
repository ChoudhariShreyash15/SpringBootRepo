package com.example.Aug20_SpringBootApplication.oracleRepo;

import com.example.Aug20_SpringBootApplication.oracleEntity.OracleTableRow;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OracleTableRepo extends JpaRepository<OracleTableRow, Long> {}

