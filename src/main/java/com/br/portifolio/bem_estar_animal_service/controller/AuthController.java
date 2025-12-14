package com.br.portifolio.bem_estar_animal_service.controller;

import com.br.portifolio.bem_estar_animal_service.dto.LoginRequestDTO;
import com.br.portifolio.bem_estar_animal_service.dto.LoginResponseDTO;
import com.br.portifolio.bem_estar_animal_service.service.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(
            @RequestBody LoginRequestDTO request
            ){
        LoginResponseDTO response = authService.login(request);
        return ResponseEntity.status(HttpStatus.OK).body(response);

    }
}
