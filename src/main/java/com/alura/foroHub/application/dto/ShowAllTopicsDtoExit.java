package com.alura.foroHub.application.dto;

import jakarta.validation.constraints.NotBlank;

public record ShowAllTopicsDtoExit(
        @NotBlank
        String title,
        @NotBlank
        String message,
        @NotBlank
        String author,
        @NotBlank
        String cursoName,
        @NotBlank
        Long courseId) { }
