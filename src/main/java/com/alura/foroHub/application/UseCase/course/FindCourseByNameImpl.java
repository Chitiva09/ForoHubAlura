package com.alura.foroHub.application.UseCase.course;

import com.alura.foroHub.application.exception.CourseNotFoundException;
import com.alura.foroHub.domain.model.Course;
import com.alura.foroHub.domain.repository.CourseRepository;
import com.alura.foroHub.domain.useCases.course.FindCourseByName;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class FindCourseByNameImpl implements FindCourseByName {
    private final CourseRepository courseRepository;

    @Override
    public Long execute(String nameCourse) {
        return courseRepository.findByNameCourse(nameCourse)
                .map(Course::getId)
                .orElseThrow(() -> new CourseNotFoundException(nameCourse));
    }
}
