package com.alura.foroHub.application.UseCase.course;

import com.alura.foroHub.application.dto.course.NewCourseDtoExit;
import com.alura.foroHub.application.exception.CourseByNameNotFoundException;
import com.alura.foroHub.application.exception.CourseNotFoundException;
import com.alura.foroHub.application.mapper.CourseAppMapper;
import com.alura.foroHub.domain.model.Course;
import com.alura.foroHub.domain.repository.CourseRepository;
import com.alura.foroHub.domain.useCases.user.ShowAllCourses;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class ShowAllCoursesImpl implements ShowAllCourses {

    private final CourseRepository courseRepository;

    @Override
    public List<NewCourseDtoExit> execute() {

        List<Course> courses = courseRepository.findAll();
        if (courses.isEmpty()){
            throw new CourseNotFoundException();
        }

        return courses.stream()
                .map(CourseAppMapper::toDto)
                .collect(Collectors.toList());
    }
}
