package com.alura.foroHub.application.dto.topic;

public record CreateTopicDtoExit(
        String title,
        String message,
        String author,
        Long id
) {
}
