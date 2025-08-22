package com.example.Aug19_SpringBootApplication.oracleRepo;

import com.example.Aug19_SpringBootApplication.entities.DocumentRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OracleDocumentRepo extends JpaRepository<DocumentRecord, Long> {}

