package com.alura.foroHub.application.dto;

import java.time.LocalDateTime;

public record TopicDto(
        String title,
        String message,
        LocalDateTime creationDate,
        Boolean status,
        String author,
        String curso
) {
}
