package com.api.marvel.controllers;

import com.api.marvel.controllers.dto.AuthCreateUserRequest;
import com.api.marvel.controllers.dto.AuthLoginRequest;
import com.api.marvel.controllers.dto.AuthResponse;
import com.api.marvel.controllers.dto.ComicDTO;
import com.api.marvel.services.impl.UserDetailServiceImpl;
import jakarta.validation.Valid;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

/**Controlador para gestionar solicitudes relacionadas con el usuario. Proporciona endpoints para operaciones de iniciar sesión y crear cuenta.*/
@RestController
@RequestMapping("/auth")
@PreAuthorize("permitAll()")
public class AuthController {

    private UserDetailServiceImpl userDetailService;

    public AuthController(UserDetailServiceImpl userDetailService) {
        this.userDetailService = userDetailService;
    }

    /**
     *Busca y verifica que las credenciales obtenidas sean correctas y enten almacenadas en la base de datos.
     * @param authLoginRequest Ingresa las credenciales
     * @return ResponseEntity que contiene un {@link AuthResponse} con los datos a responder.
     */
    @PostMapping("/log-in")
    public ResponseEntity<AuthResponse> login(@RequestBody @Valid AuthLoginRequest authLoginRequest){
        return new ResponseEntity<>(userDetailService.loginUser(authLoginRequest), HttpStatus.OK);
    }

    /**
     * Crea cuenta para el usuario posteriormente iniciar sesión.
     * @param authCreateUserRequest  Datos para crear usuario.
     * @return ResponseEntity que contiene un {@link AuthResponse} con los datos a responder.
     */
    @PostMapping("/sign-up")
    public ResponseEntity<AuthResponse> register(@RequestBody @Valid AuthCreateUserRequest authCreateUserRequest){
        return new ResponseEntity<>(userDetailService.createUser(authCreateUserRequest), HttpStatus.OK);
    }
}
