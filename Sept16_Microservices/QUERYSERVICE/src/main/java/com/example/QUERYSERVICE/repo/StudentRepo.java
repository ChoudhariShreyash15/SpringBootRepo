package com.example.QUERYSERVICE.repo;

import com.example.QUERYSERVICE.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface StudentRepo extends JpaRepository<Student,Integer> {

}
