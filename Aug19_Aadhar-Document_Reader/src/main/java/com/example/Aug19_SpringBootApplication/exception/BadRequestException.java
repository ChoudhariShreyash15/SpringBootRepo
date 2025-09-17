package com.example.Aug19_SpringBootApplication.exception;

public class BadRequestException extends RuntimeException {
    public BadRequestException(String msg) { super(msg); }
}

