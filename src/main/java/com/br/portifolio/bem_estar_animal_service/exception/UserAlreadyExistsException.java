package com.br.portifolio.bem_estar_animal_service.exception;

public class UserAlreadyExistsException extends RuntimeException {
    public UserAlreadyExistsException(String email) {
        super("A user with the same email already exists: " + email);
    }
}
