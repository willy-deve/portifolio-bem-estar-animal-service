package com.br.portifolio.bem_estar_animal_service.repository;

import com.br.portifolio.bem_estar_animal_service.dto.UserPerfilResponseDTO;
import com.br.portifolio.bem_estar_animal_service.entity.Profile;
import com.br.portifolio.bem_estar_animal_service.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);

    @Query("""
    SELECT new com.br.portifolio.bem_estar_animal_service.dto.UserPerfilResponseDTO(
        u.id, u.name, u.email, u.profile, u.approved
    )
    FROM User u
    WHERE u.profile = :profile
      AND u.approved = false
""")
    List<UserPerfilResponseDTO> findByPerfil(@Param("profile") Profile profile);
}
