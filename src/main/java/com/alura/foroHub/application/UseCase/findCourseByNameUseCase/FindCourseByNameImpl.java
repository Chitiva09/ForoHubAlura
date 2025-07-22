package com.alura.foroHub.application.UseCase.findCourseByNameUseCase;

import com.alura.foroHub.domain.model.Course;
import com.alura.foroHub.domain.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FindCourseByNameImpl implements FindCourseByName {
    private final CourseRepository courseRepository;


    @Override
    public String findCourseByName(String nameCourse){
       String idCourse = courseRepository.findByNameCourse(nameCourse)
                .orElseThrow(() -> new RuntimeException("Curso no encontrado"));
    }

}
