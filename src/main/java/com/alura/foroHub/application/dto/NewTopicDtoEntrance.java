package com.alura.foroHub.application.dto;

import jakarta.validation.constraints.NotBlank;

public record NewTopicDtoEntrance(

        String title,
        String message,
        String author,
        String cursoName,
        Long courseId
) {
}
