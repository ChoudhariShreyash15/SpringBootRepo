package com.example.ACTIONSERVICE.controller;

import com.example.ACTIONSERVICE.dto.StudentDto;
import com.example.ACTIONSERVICE.entity.Student;
import com.example.ACTIONSERVICE.service.StudentService;
import jakarta.ws.rs.Path;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @PostMapping("/add")
    public Student addStudent(@RequestBody StudentDto studentDto){
        return studentService.addStudent(studentDto);
    }

    @PostMapping("/addAll")
    public List<Student> addAllStudents(@RequestBody List<StudentDto> student){
        return studentService.addAllStudents(student);
    }

    @PutMapping("/update")
    public Student updateStudent(@RequestParam int id, @RequestParam String dept){
        return studentService.updateStudent(id, dept);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteStudent(@PathVariable int id){
        return studentService.deleteStudent(id);
    }

    @GetMapping("/getByRestTemplate/{id}")
    public Student getByRestTemplate(@PathVariable Integer id){
        return studentService.getByRestTemplate(id);
    }

    @GetMapping("/getByWebClient/{id}")
    public Student getByWebClient(@PathVariable Integer id){
        return studentService.getByWebClient(id);
    }
}
