package com.example.QUERYSERVICE.controller;

import com.example.QUERYSERVICE.entity.Student;
import com.example.QUERYSERVICE.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/get/{id}")
    public Student getById(@PathVariable int id){
        return studentService.getById(id);
    }

    @GetMapping("/getAll")
    public List<Student> getAll(){
        return studentService.getAll();
    }
}
