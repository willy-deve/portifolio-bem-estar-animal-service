package com.br.portifolio.bem_estar_animal_service.dto;

import com.br.portifolio.bem_estar_animal_service.entity.Profile;
import lombok.Data;

@Data
public class LoginResponseDTO {
    private String token;
    private String email;
    private Profile profile;

    public LoginResponseDTO(String token, String email, Profile profile) {
        this.token = token;
        this.email = email;
        this.profile = profile;
    }
}
