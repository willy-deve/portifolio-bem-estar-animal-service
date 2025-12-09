package com.br.portifolio.bem_estar_animal_service.dto.user;

import com.br.portifolio.bem_estar_animal_service.entity.Profile;
import lombok.Data;

@Data
public class UserRequestDTO {
    private String name;
    private String email;
    private String password;
    private Profile profile;
}
