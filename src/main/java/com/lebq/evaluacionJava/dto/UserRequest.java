package com.lebq.evaluacionJava.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Pattern;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class UserRequest {

    private String name;

    @Pattern(
            regexp = "",
            message = "El email debe tener el formato correcto"
    )
    private String email;

    @Pattern(
            regexp = "",
            message = "La contraseña debe cumplir con el formato requerido"
    )
    private String password;

    private List<PhoneRequest> phones;

    private LocalDateTime created;
    private LocalDateTime updated;
    private LocalDateTime lastLogin;
    private String token;
    private boolean isActive;
}
