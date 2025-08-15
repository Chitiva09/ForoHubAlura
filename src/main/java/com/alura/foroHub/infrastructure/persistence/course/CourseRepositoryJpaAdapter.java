package com.alura.foroHub.infrastructure.persistence.course;

import com.alura.foroHub.domain.model.Course;
import com.alura.foroHub.domain.repository.CourseRepository;
import com.alura.foroHub.infrastructure.entity.CourseEntity;
import com.alura.foroHub.infrastructure.mapper.CourseInfraMapper;
import lombok.RequiredArgsConstructor;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class CourseRepositoryJpaAdapter implements CourseRepository {

    private final CourseRepositoryJpa jpa;


    @Override
    public Optional<Course> findByNameCourse(String nameCourse) {
        return jpa.findByNameCourse(nameCourse)
                .map(CourseInfraMapper::toDomain);

    }

    @Override
    public Course save(Course course) {
        CourseEntity courseEntity = CourseInfraMapper.toEntity(course);
        jpa.save(courseEntity);
        return CourseInfraMapper.toDomain(courseEntity);
    }


    @Override
    public List<Course> findAll() {

        return jpa.findAll().stream()
                .map(CourseInfraMapper::toDomain)
                .collect(Collectors.toList());
    }
}
