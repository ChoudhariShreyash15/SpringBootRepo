package com.example.Aug19_SpringBootApplication.mysqlRepo;

import com.example.Aug19_SpringBootApplication.entities.AadhaarRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MysqlAadhaarRepository extends JpaRepository<AadhaarRecord, Long> {}

