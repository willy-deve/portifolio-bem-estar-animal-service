package com.br.portifolio.bem_estar_animal_service.controller;

import com.br.portifolio.bem_estar_animal_service.dto.ApproveRequestDTO;
import com.br.portifolio.bem_estar_animal_service.dto.UserPerfilResponseDTO;
import com.br.portifolio.bem_estar_animal_service.dto.UserRequestDTO;
import com.br.portifolio.bem_estar_animal_service.dto.UserResponseDTO;
import com.br.portifolio.bem_estar_animal_service.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/create")
    public ResponseEntity<UserResponseDTO> createUser(@RequestBody UserRequestDTO request) {
        UserResponseDTO response = userService.createUeser(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/perfil")
    public ResponseEntity<List<UserPerfilResponseDTO>> getPerfilByUser(){
        List<UserPerfilResponseDTO> response = userService.getPerfilByOng();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PutMapping("/perfil/aprovar")
    public ResponseEntity<UserPerfilResponseDTO> approvePerfil(
            @RequestBody ApproveRequestDTO request
            ) {
        UserPerfilResponseDTO response = userService.approvePerfil(request.id(), request.approved());
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }


}
