package com.alura.foroHub.infrastructure.repository.course;

import com.alura.foroHub.domain.model.Course;
import com.alura.foroHub.domain.repository.CourseRepository;
import org.aspectj.apache.bcel.classfile.Module;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class CourseRepositoryJpaImpl implements CourseRepository {

    private final CourseRepositoryJpa jpa;


    public CourseRepositoryJpaImpl (CourseRepositoryJpa jpa){
        this.jpa = jpa;
    }

    @Override
    public Optional<Course> findByNameCourse(String nameCourse) {
        return jpa.findByNameCourse(nameCourse);
    }


}
