package com.br.portifolio.bem_estar_animal_service.dto;

import com.br.portifolio.bem_estar_animal_service.entity.Profile;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserPerfilResponseDTO {

    private Long id;
    private String name;
    private String email;
    private Profile profile;
    private Boolean approved;
}
