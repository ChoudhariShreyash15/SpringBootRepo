package com.example.ACTIONSERVICE.service;

import com.example.ACTIONSERVICE.dto.StudentDto;
import com.example.ACTIONSERVICE.entity.Student;
import com.example.ACTIONSERVICE.repo.Feign;
import com.example.ACTIONSERVICE.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepo studentRepo;

    @Autowired
    private Feign feign;

    public Student addStudent(StudentDto studentDto){
        Student student = new Student();
        student.setName(studentDto.getName());
        student.setDept(studentDto.getDept());
        return studentRepo.save(student);
    }

    public List<Student> addAllStudents(List<StudentDto> studentDtoList){
        List<Student> studentList = new ArrayList<>();
        for(StudentDto studentDto : studentDtoList){
            Student student1 = new Student();
            student1.setName(studentDto.getName());
            student1.setDept(studentDto.getDept());
            studentList.add(student1);
        }
        return studentRepo.saveAll(studentList);
    }

    public Student updateStudent(int id, String dept){
        Student student = feign.getById(id);
        if(student != null){
            student.setDept(dept);
            return studentRepo.save(student);
        }
        throw new RuntimeException("ID Not Found");
    }

    public String deleteStudent(int id){
        Student student = feign.getById(id);
        if (student != null){
            studentRepo.deleteById(id);
            return "Deleted Successfully";
        }
        throw new RuntimeException("ID Not Found!");
    }
}
