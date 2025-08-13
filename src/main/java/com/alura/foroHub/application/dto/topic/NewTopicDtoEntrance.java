package com.alura.foroHub.application.dto.topic;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record NewTopicDtoEntrance(

        @NotBlank String title,
        @NotBlank String message,
        @NotBlank String author,
        @NotBlank String cursoName,
        @NotNull Long courseId
) {
}
