package com.alura.foroHub.application.dto.topic;

import java.time.LocalDateTime;

public record TopicsByIdDtoExit(
        Long id,
        String title,
        String message,
        LocalDateTime creationDate,
        String status,
        String author,
        String cursoName

) {
}
