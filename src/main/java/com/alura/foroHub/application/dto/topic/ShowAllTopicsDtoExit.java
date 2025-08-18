package com.alura.foroHub.application.dto.topic;

import java.time.LocalDateTime;

public record ShowAllTopicsDtoExit(
        Long id,
        String title,
        String message,
        LocalDateTime creationDate,
        String status,
        String author,
        String courseName,
        Long courseId) {
}
