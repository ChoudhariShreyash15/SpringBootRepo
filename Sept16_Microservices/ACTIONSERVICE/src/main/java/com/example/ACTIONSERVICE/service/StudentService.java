package com.example.ACTIONSERVICE.service;

import com.example.ACTIONSERVICE.configuration.WebClientConfig;
import com.example.ACTIONSERVICE.dto.StudentDto;
import com.example.ACTIONSERVICE.entity.Student;
import com.example.ACTIONSERVICE.repo.Feign;
import com.example.ACTIONSERVICE.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepo studentRepo;

    @Autowired
    private Feign feign;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private WebClient.Builder builder;

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

    public Student getByRestTemplate(Integer id){
        String url = "http://localhost:8090/student/get/" + id;
        return restTemplate.getForObject(url, Student.class);
    }

    public Student getByWebClient(Integer id){
        return builder.build()
                .get()
                .uri("http://QUERYSERVICE/student/get/{id}", id)
                .retrieve()
                .bodyToMono(Student.class)
                .block();
    }
}
