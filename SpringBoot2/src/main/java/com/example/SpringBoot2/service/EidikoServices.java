package com.example.SpringBoot2.service;

import com.example.SpringBoot2.entity.Eidiko;
import com.example.SpringBoot2.exception.EmployeeNotFoundException;
import com.example.SpringBoot2.repo.EidikoRepo;
import jakarta.persistence.SequenceGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EidikoServices {
    @Autowired
    private EidikoRepo eidikoRepo;

    //GET or Read
    public Eidiko getEmployee(int empId){
        Eidiko eidiko;
        try{
            eidiko = eidikoRepo.findById(empId).orElseThrow(()->{
                throw new EmployeeNotFoundException("Employee Not Found");
            });
        }
        catch (EmployeeNotFoundException e){
            throw  e;
        }
        return eidiko;
    }

    //POST or Create
    public Eidiko addEmployee(Eidiko eidiko){
        return eidikoRepo.save(eidiko);
    }

}
