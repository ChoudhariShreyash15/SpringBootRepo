package com.example.SpringBoot2.controller;

import com.example.SpringBoot2.entity.Eidiko;
import com.example.SpringBoot2.repo.EidikoRepo;
import com.example.SpringBoot2.response.ResponseHandler;
import com.example.SpringBoot2.service.EidikoServices;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class EidikoController {
    @Autowired
    private EidikoServices eidikoServices;

    //Read or Select or GET or Retrive
    @GetMapping("/get/{empId}")
    public Eidiko getEmployee(@RequestParam("empId") int id){
        return eidikoServices.getEmployee(id);
    }

    //Create or add or POST
    @PostMapping("/add")
    public ResponseEntity<ResponseHandler> addEmployee(@RequestBody Eidiko eidiko){
        eidikoServices.addEmployee(eidiko);
        ResponseHandler responseHandler = new ResponseHandler("Data Added" , HttpStatus.CREATED, eidiko);
        return new ResponseEntity<>(responseHandler , HttpStatus.CREATED);
    }


    @PostMapping("/object")
    public Eidiko addObject(@RequestBody String eidiko) throws JsonProcessingException {
        ObjectMapper objectMapper= new ObjectMapper();
        return objectMapper.readValue(eidiko,Eidiko.class);
    }
}

