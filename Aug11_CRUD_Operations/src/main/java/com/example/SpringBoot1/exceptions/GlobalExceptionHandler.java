package com.example.SpringBoot1.exceptions;

import com.example.SpringBoot1.response.ResponseHandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BankAccNotFoundException.class)
    public ResponseEntity<Map> BankAccNotFoundException(BankAccNotFoundException bankAccNotFoundException){
        Map<String,String> m = new HashMap<>();
        m.put("message","Account Not Found");
        m.put("HttpStatus", HttpStatus.NOT_FOUND.toString());
        return new ResponseEntity<>(m,HttpStatus.OK);
}

//    @ExceptionHandler(BankAccNotFoundException.class)
//    public ResponseEntity<ResponseHandler> BankAccNotFoundException(BankAccNotFoundException bankAccNotFoundException){
//        ResponseHandler r = new ResponseHandler("Account Not Found", HttpStatus.NOT_FOUND);
//        return new ResponseEntity<>(r,HttpStatus.NOT_FOUND);
//    }
}
