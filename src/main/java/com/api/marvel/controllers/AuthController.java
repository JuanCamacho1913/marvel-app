package com.api.marvel.controllers;

import com.api.marvel.controllers.dto.AuthCreateUserRequest;
import com.api.marvel.controllers.dto.AuthLoginRequest;
import com.api.marvel.controllers.dto.AuthResponse;
import com.api.marvel.services.impl.UserDetailServiceImpl;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private UserDetailServiceImpl userDetailService;

    public AuthController(UserDetailServiceImpl userDetailService) {
        this.userDetailService = userDetailService;
    }

    @PostMapping("/log-in")
    public ResponseEntity<AuthResponse> login(@RequestBody @Valid AuthLoginRequest authLoginRequest){
        return new ResponseEntity<>(userDetailService.loginUser(authLoginRequest), HttpStatus.OK);
    }

    @PostMapping("/sign-up")
    public ResponseEntity<AuthResponse> register(@RequestBody @Valid AuthCreateUserRequest authCreateUserRequest){
        return new ResponseEntity<>(userDetailService.createUser(authCreateUserRequest), HttpStatus.OK);
    }
}
