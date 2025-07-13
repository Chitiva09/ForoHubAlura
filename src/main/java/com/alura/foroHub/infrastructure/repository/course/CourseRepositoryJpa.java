package com.alura.foroHub.infrastructure.repository.course;

import com.alura.foroHub.domain.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CourseRepositoryJpa extends JpaRepository <Course , Long>{

    Optional<Course> findByNameCourse (String cursoName);
}
