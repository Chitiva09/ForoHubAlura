package com.alura.foroHub.infrastructure.repository.course;

import com.alura.foroHub.domain.model.Course;
import com.alura.foroHub.domain.repository.CourseRepository;
import com.alura.foroHub.infrastructure.entity.CourseEntity;
import com.alura.foroHub.infrastructure.mapper.CourseInfraMapper;


import java.util.Optional;


public class CourseRepositoryJpaImpl implements CourseRepository {

    private final CourseRepositoryJpa jpa;
    private final CourseInfraMapper courseInfraMapper;

    public CourseRepositoryJpaImpl (CourseRepositoryJpa jpa, CourseInfraMapper courseInfraMapper){
        this.courseInfraMapper = courseInfraMapper;
        this.jpa = jpa;
    }
    @Override
    public Optional<Course> findByNameCourse(String nameCourse) {

        return jpa.findByNameCourse(nameCourse)
                .map(courseInfraMapper :: toDomain);
    }


}
