package com.alura.foroHub.infrastructure.persistence.course;

import com.alura.foroHub.domain.model.Course;
import com.alura.foroHub.domain.repository.CourseRepository;
import com.alura.foroHub.infrastructure.mapper.CourseInfraMapper;
import lombok.RequiredArgsConstructor;


import java.util.Optional;

@RequiredArgsConstructor
public class CourseRepositoryJpaAdapter implements CourseRepository {

    private final CourseRepositoryJpa jpa;


    @Override
    public Optional<Course> findByNameCourse(String nameCourse) {

        return jpa.findByNameCourse(nameCourse)
                .map(CourseInfraMapper:: toDomain);
    }


}
