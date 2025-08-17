package com.alura.foroHub.application.UseCase.course;

import com.alura.foroHub.domain.model.Course;
import com.alura.foroHub.domain.repository.CourseRepository;
import com.alura.foroHub.domain.useCases.course.FindCourseByName;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor
public class FindCourseByNameImpl implements FindCourseByName {
    private final CourseRepository courseRepository;

    //Optional nunca es null: Un Optional es un objeto contenedor. Cuando courseRepository.findByNameCourse no encuentra un curso, no devuelve null. Devuelve un objeto Optional vacío (Optional.empty()). Por eso, tu condición if (course == null) nunca se cumplirá.
    @Override
    public Optional<Course> execute(String nameCourse) {

        return courseRepository.findByNameCourse(nameCourse);
    }
}

