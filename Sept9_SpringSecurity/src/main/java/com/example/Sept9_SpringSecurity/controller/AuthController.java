package com.example.Sept9_SpringSecurity.controller;

import com.example.Sept9_SpringSecurity.dto.AuthRequestDto;
import com.example.Sept9_SpringSecurity.dto.TokenDto;
import com.example.Sept9_SpringSecurity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @GetMapping("/authenticate")
    public ResponseEntity<String> authenticate(@RequestBody AuthRequestDto authRequestDto)
    {
        return ResponseEntity.ok(userService.authenticate(authRequestDto));
    }

    @GetMapping("/both")
    public ResponseEntity<TokenDto> getBothToken(@RequestBody AuthRequestDto authRequestDto)
    {
        return ResponseEntity.ok(userService.getBothToken(authRequestDto));
    }
}
