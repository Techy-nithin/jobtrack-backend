package com.jobtrack.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jobtrack.dto.LoginRequest;
import com.jobtrack.dto.LoginResponse;
import com.jobtrack.dto.RegisterResponse;
import com.jobtrack.entity.User;
import com.jobtrack.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public RegisterResponse registerUser(@RequestBody @Valid User user) {

        User registeredUser = userService.registerUser(user);


        return new RegisterResponse(
                registeredUser.getId(),
                registeredUser.getName(),
                registeredUser.getEmail()
        );
    }

    @PostMapping("/login")
    public LoginResponse loginUser(
            @RequestBody @Valid LoginRequest loginRequest) {

        return userService.loginUser(loginRequest);
    }
}