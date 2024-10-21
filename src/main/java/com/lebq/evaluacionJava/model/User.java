package com.lebq.evaluacionJava.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import javax.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Schema(description = "Identificador único del usuario", example = "1")
    private UUID id;

    @Schema(description = "Nombre del usuario", example = "Pepito Pérez")
    private String name;

    @Schema(description = "Correo electrónico del usuario", example = "pepito.perez@correo.com")
    @Column(unique = true)
    private String email;

    @Schema(description = "Contraseña del usuario")
    private String password;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private List<Phone> phones;

    private LocalDateTime created;
    private LocalDateTime updated;
    private LocalDateTime lastLogin;
    private String token;
    private boolean isActive;
}
