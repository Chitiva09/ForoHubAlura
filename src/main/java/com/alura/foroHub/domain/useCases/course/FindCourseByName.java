package com.alura.foroHub.domain.useCases.course;


import com.alura.foroHub.domain.model.Course;

import java.util.Optional;

public interface FindCourseByName {
    Optional<Course> execute (String nameCourse);
}
