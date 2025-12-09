package com.br.portifolio.bem_estar_animal_service.entitie;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "USUARIOS")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NOME", nullable = false, length = 200)
    private String name;

    @Column(name = "EMAIL", nullable = false, length = 200)
    private String email;

    @Column(name = "SENHA", nullable = false, length = 200)
    private String password;

    @Column(name = "PERFIL", nullable = false, length = 50)
    @Enumerated(EnumType.STRING)
    private Profile profile;

    @Column(name = "APROVADO")
    private Boolean approved;

}
