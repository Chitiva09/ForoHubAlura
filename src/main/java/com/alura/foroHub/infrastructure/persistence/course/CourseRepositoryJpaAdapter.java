package com.alura.foroHub.infrastructure.persistence.course;

import com.alura.foroHub.domain.model.Course;
import com.alura.foroHub.domain.repository.CourseRepository;
import com.alura.foroHub.infrastructure.mapper.FindByNameCourseInfraMapper;


import java.util.Optional;


public class CourseRepositoryJpaAdapter implements CourseRepository {

    private final CourseRepositoryJpa jpa;
    private final FindByNameCourseInfraMapper findByNameCourseInfraMapper;

    public CourseRepositoryJpaAdapter(CourseRepositoryJpa jpa, FindByNameCourseInfraMapper findByNameCourseInfraMapper){
        this.findByNameCourseInfraMapper = findByNameCourseInfraMapper;
        this.jpa = jpa;
    }

    @Override
    public Optional<Course> findByNameCourse(String nameCourse) {

        return jpa.findByNameCourse(nameCourse)
                .map(findByNameCourseInfraMapper:: toDomain);
    }


}
