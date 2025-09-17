package com.example.Aug19_SpringBootApplication.oracleRepo;

import com.example.Aug19_SpringBootApplication.entities.AadhaarRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OracleAadhaarRepository extends JpaRepository<AadhaarRecord, Long> {}

