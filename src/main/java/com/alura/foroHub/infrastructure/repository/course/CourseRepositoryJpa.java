package com.alura.foroHub.infrastructure.repository.course;

import com.alura.foroHub.infrastructure.entity.CourseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CourseRepositoryJpa extends JpaRepository <CourseEntity, Long>{

    Optional<CourseEntity> findByNameCourse (String nameCourse);
}
