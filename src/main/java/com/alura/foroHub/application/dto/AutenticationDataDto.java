package com.alura.foroHub.application.dto;

import jakarta.validation.constraints.NotBlank;

public record AutenticationDataDto(
       @NotBlank String userName,
       @NotBlank String userPassword
) {
}
