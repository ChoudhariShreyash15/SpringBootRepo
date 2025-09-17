package com.example.SpringBoot1.response;

import com.example.SpringBoot1.entity.Bank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseHandler<T> {
    private String message;
    private HttpStatus httpStatus;
    private T bank;
}
