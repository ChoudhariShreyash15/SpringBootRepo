package com.example.Aug20_SpringBootApplication.mysqlRepo;

import com.example.Aug20_SpringBootApplication.mysqlEntity.MysqlTableRow;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MysqlTableRepo extends JpaRepository<MysqlTableRow, Long> {}



