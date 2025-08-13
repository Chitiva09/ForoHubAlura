package com.alura.foroHub.application.dto.authentication;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record CreateUserDtoEntrance(

        @NotBlank String userName,
        @Email String email,
        @NotBlank(message = "La contraseña no puede estar vaciá ")
        String password

) {
}
