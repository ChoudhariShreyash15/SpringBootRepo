package com.example.ACTIONSERVICE.repo;

import com.example.ACTIONSERVICE.entity.Student;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient("QUERYSERVICE")
public interface Feign {

    @GetMapping("/student/get/{id}")
    public Student getById(@PathVariable int id);

    @GetMapping("/student/getAll")
    public List<Student> getAll();
}
