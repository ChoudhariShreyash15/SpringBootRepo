package com.example.SpringBoot1.exceptions;

public class BankAccNotFoundException extends RuntimeException{

    public BankAccNotFoundException(String message){
        super(message);
    }
}
