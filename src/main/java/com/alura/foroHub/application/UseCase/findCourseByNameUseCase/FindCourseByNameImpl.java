package com.alura.foroHub.application.UseCase.findCourseByNameUseCase;

import com.alura.foroHub.application.UseCase.findCourseByNameUseCase.FindCourseByName;
import com.alura.foroHub.domain.model.Course;
import com.alura.foroHub.domain.repository.CourseRepository;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
public class FindCourseByNameImpl implements FindCourseByName {
    private final CourseRepository courseRepository;


    @Override
    public Long execute(String nameCourse){
       Course course = courseRepository.findByNameCourse(nameCourse)
                .orElseThrow(() -> new RuntimeException("Curso no encontrado"));

        return course.getId();
    }
}
