package com.login.ecommerce_api.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.login.ecommerce_api.model.User;
import com.login.ecommerce_api.service.AuthenticatorService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/Authenticator")
public class AuthenticatorController {
    
    private final AuthenticatorService authService;

    //Register
    @PostMapping("/register")
    public User register(@RequestParam String username,
                        @RequestParam String password) {
        return authService.register(username, password);
    }

    //Login
    @PostMapping("/login")
    public User login(@RequestParam String username,
                      @RequestParam String password){
        return authService.login(username, password);
    }
}
