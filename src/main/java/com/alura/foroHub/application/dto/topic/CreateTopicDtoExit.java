package com.alura.foroHub.application.dto.topic;

import jakarta.validation.constraints.NotBlank;

public record CreateTopicDtoExit(
        @NotBlank String title,
        @NotBlank String message,
        @NotBlank String author,
        @NotBlank Long id
) {
}
