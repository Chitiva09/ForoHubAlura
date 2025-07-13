package com.alura.foroHub.application.dto;

import jakarta.validation.constraints.NotBlank;

public record NewTopicDtoEntrance(
        @NotBlank
        String title,
        @NotBlank
        String message,
        @NotBlank
        String author,
        @NotBlank
        String cursoName
) {
}
