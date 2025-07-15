package com.alura.foroHub.domain.repository;

import com.alura.foroHub.infrastructure.entity.CourseEntity;

import java.util.Optional;

public interface CourseRepository {
    Optional<CourseEntity> findByNameCourse(String nameCourse);
}
