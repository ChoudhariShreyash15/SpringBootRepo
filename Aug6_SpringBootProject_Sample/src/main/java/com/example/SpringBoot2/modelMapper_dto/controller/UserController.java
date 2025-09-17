package com.example.SpringBoot2.modelMapper_dto.controller;

import com.example.SpringBoot2.modelMapper_dto.dto.UserDTO;
import com.example.SpringBoot2.modelMapper_dto.entity.UserEntity;
import com.example.SpringBoot2.modelMapper_dto.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService; //Field Injection

    @PostMapping("/convert")
    public UserDTO convertEntityToDTO(@RequestBody UserEntity userEntity) {
        return userService.convertToDTO(userEntity);
    }
}