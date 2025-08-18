package com.alura.foroHub.infrastructure.persistence.course;


import com.alura.foroHub.infrastructure.entity.CourseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface CourseRepositoryJpa extends JpaRepository<CourseEntity, Long> {

    Optional<CourseEntity> findByNameCourse(String nameCourse);
}
