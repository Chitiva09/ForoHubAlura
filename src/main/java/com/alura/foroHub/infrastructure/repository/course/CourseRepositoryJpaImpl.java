package com.alura.foroHub.infrastructure.repository.course;

import com.alura.foroHub.domain.model.Course;
import org.aspectj.apache.bcel.classfile.Module;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class CourseRepositoryJpaImpl {

    Optional<Course> findByNameCourse(String cursoName) {
        return Optional.empty();
    }


}
