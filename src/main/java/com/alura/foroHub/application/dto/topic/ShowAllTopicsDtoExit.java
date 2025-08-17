package com.alura.foroHub.application.dto.topic;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;

public record ShowAllTopicsDtoExit(
        @NotBlank Long id,
        @NotBlank String title,
        @NotBlank String message,
        @NotBlank LocalDateTime creationDate,
        @NotBlank String status,
        @NotBlank String author,
        @NotBlank String courseName,
        @NotBlank Long courseId) {
}
