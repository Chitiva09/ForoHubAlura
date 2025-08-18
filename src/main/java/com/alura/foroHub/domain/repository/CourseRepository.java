package com.alura.foroHub.domain.repository;

import com.alura.foroHub.domain.model.Course;

import java.util.List;
import java.util.Optional;

public interface CourseRepository {
    List<Course> findAll();

    Optional<Course> findByNameCourse(String nameCourse);

    Course save(Course course);

}
