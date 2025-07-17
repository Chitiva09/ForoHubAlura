package com.alura.foroHub.domain.repository;

import com.alura.foroHub.domain.model.Course;

import java.util.Optional;

public interface CourseRepository {
    Optional<Course> findByNameCourse(String nameCourse);
}
