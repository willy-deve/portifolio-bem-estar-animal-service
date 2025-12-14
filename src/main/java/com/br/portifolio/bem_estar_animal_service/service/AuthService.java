package com.br.portifolio.bem_estar_animal_service.service;

import com.br.portifolio.bem_estar_animal_service.dto.LoginRequestDTO;
import com.br.portifolio.bem_estar_animal_service.dto.LoginResponseDTO;
import com.br.portifolio.bem_estar_animal_service.entity.User;
import com.br.portifolio.bem_estar_animal_service.repository.UserRepository;
import com.br.portifolio.bem_estar_animal_service.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public LoginResponseDTO login(LoginRequestDTO dto) {
        User user = userRepository.findByEmail(dto.getEmail()).orElseThrow(()-> new RuntimeException("User not found"));

        if (!passwordEncoder.matches(dto.getPassword(), user.getPassword())) {
            throw new RuntimeException("Invalid credentials");
        }

        String token = JwtUtil.generateToken(user);

        return new LoginResponseDTO(token, user.getEmail(), user.getProfile());
    }

}
