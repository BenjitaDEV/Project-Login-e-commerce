package com.login.ecommerce_api.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.login.ecommerce_api.dto.LoginRequest;
import com.login.ecommerce_api.dto.RegisterRequest;
import com.login.ecommerce_api.model.User;
import com.login.ecommerce_api.service.AuthenticatorService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/Authenticator")
public class AuthenticatorController {
    
    private final AuthenticatorService authService;

    //Register
    @PostMapping("/register")
    public User register(@Valid @RequestBody RegisterRequest request){
        return authService.register(
                request.username(), 
                request.password());
    }
    //Login
    @PostMapping("/login")
    public User login(@Valid @RequestBody LoginRequest request){
        return authService.login(
            request.username(), 
            request.password());
    }
}
