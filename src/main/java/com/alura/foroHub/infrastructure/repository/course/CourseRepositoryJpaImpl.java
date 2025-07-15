package com.alura.foroHub.infrastructure.repository.course;

import com.alura.foroHub.infrastructure.entity.CourseEntity;
import com.alura.foroHub.domain.repository.CourseRepository;

import java.util.Optional;


public class CourseRepositoryJpaImpl implements CourseRepository {

    private final CourseRepositoryJpa jpa;


    public CourseRepositoryJpaImpl (CourseRepositoryJpa jpa){
        this.jpa = jpa;
    }

    @Override
    public Optional<CourseEntity> findByNameCourse(String nameCourse) {
        return jpa.findByNameCourse(nameCourse);
    }


}
