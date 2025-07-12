package com.alura.foroHub.application.dto;

import com.alura.foroHub.domain.model.Course;
import com.alura.foroHub.domain.model.UserEntity;

import java.time.LocalDateTime;

public record TopicDto(
        String title,
        String message,
        LocalDateTime creationDate,
        Boolean status,
        UserEntity author,
        Course curso
) {
}
