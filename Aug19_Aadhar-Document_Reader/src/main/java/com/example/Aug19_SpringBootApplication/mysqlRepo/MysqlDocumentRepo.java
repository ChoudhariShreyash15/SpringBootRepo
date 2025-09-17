package com.example.Aug19_SpringBootApplication.mysqlRepo;

import com.example.Aug19_SpringBootApplication.entities.DocumentRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MysqlDocumentRepo extends JpaRepository<DocumentRecord, Long> {}

