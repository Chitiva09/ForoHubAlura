package com.alura.foroHub.application.UseCase;

import com.alura.foroHub.application.exception.CourseNotFoundException;
import com.alura.foroHub.domain.model.Course;
import com.alura.foroHub.domain.repository.CourseRepository;
import com.alura.foroHub.domain.useCases.FindCourseByName;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class FindCourseByNameImpl implements FindCourseByName {
    private final CourseRepository courseRepository;

    @Override
    public Long execute(String nameCourse) {
        Course course = courseRepository.findByNameCourse(nameCourse)
                .orElseThrow(() -> new CourseNotFoundException(nameCourse));
        return course.getId();
    }
}
