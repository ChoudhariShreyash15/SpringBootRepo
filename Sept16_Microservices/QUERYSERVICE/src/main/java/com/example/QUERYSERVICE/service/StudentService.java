package com.example.QUERYSERVICE.service;

import com.example.QUERYSERVICE.entity.Student;
import com.example.QUERYSERVICE.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepo studentRepo;

    public Student getById(int id){
        return studentRepo.findById(id).orElseThrow(()-> new RuntimeException("Student Not Found"));
    }

    public List<Student> getAll(){
        return studentRepo.findAll();
    }
}
