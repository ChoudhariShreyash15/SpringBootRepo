package com.example.SpringBoot_Connecting_Multiple_Databases.oracleRepo;

import com.example.SpringBoot_Connecting_Multiple_Databases.oracleEntity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepo  extends JpaRepository<Student, Integer> {
}
