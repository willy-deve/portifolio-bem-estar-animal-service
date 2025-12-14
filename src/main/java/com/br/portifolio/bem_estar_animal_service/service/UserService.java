package com.br.portifolio.bem_estar_animal_service.service;

import com.br.portifolio.bem_estar_animal_service.dto.UserPerfilResponseDTO;
import com.br.portifolio.bem_estar_animal_service.dto.UserRequestDTO;
import com.br.portifolio.bem_estar_animal_service.dto.UserResponseDTO;
import com.br.portifolio.bem_estar_animal_service.entity.Profile;
import com.br.portifolio.bem_estar_animal_service.entity.User;
import com.br.portifolio.bem_estar_animal_service.exception.UserAlreadyExistsException;
import com.br.portifolio.bem_estar_animal_service.mapper.UserMapper;
import com.br.portifolio.bem_estar_animal_service.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper mapper;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, UserMapper mapper, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.mapper = mapper;
        this.passwordEncoder =passwordEncoder;
    }

    public UserResponseDTO createUeser(UserRequestDTO request) {

            if (userRepository.findByEmail(request.getEmail()).isPresent()) {
                throw new UserAlreadyExistsException(request.getEmail());
            }

            User user = mapper.toEntity(request);
            user.setPassword(passwordEncoder.encode(request.getPassword()));
            user.setApproved(!request.getProfile().equals(Profile.ONG));
            user = userRepository.save(user);

            return mapper.toResponseDTO(user);
    }

    public List<UserPerfilResponseDTO> getPerfilByOng(){
         List<UserPerfilResponseDTO> userPerfilResponseDTO = userRepository.findByPerfil(Profile.ONG);
        System.out.println("Perfil" + userPerfilResponseDTO);
         return userPerfilResponseDTO;
    }

    public UserPerfilResponseDTO approvePerfil(Long id, Boolean approved) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));

        user.setApproved(approved);
        userRepository.save(user);

        return new UserPerfilResponseDTO(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getProfile(),
                user.getApproved()
        );
    }


}