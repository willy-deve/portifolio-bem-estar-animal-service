package com.br.portifolio.bem_estar_animal_service.mapper;

import com.br.portifolio.bem_estar_animal_service.dto.user.UserRequestDTO;
import com.br.portifolio.bem_estar_animal_service.dto.user.UserResponseDTO;
import com.br.portifolio.bem_estar_animal_service.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User toEntity(UserRequestDTO dto);
    UserResponseDTO toResponseDTO(User user);
}
