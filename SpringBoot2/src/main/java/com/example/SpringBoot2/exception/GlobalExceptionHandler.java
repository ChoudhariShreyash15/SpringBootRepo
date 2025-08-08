package com.example.SpringBoot2.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(EmployeeNotFoundException.class)
    public ResponseEntity<Map<String,String>> EmployeeNotFoundException(EmployeeNotFoundException employeeNotFoundException){
        Map<String,String> empNotFound = new HashMap<>();
        empNotFound.put("message","Employee Not Found"); // message(Key) : Employee Not Found(value)
        empNotFound.put("Http Status Code", HttpStatus.NOT_FOUND.toString());
        return new ResponseEntity<>(empNotFound,HttpStatus.NOT_FOUND);
    }
}
