package com.alura.foroHub.application.UseCase.course;

import com.alura.foroHub.application.dto.course.NewCourseDtoEntrance;
import com.alura.foroHub.application.dto.course.NewCourseDtoExit;
import com.alura.foroHub.application.exception.CourseAlreadyExistsException;
import com.alura.foroHub.application.mapper.CourseAppMapper;
import com.alura.foroHub.domain.model.Course;
import com.alura.foroHub.domain.model.Topic;
import com.alura.foroHub.domain.repository.CourseRepository;
import com.alura.foroHub.domain.useCases.course.FindCourseByName;
import com.alura.foroHub.domain.useCases.course.RegistrationNewCourse;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class RegistrationNewCourseImpl implements RegistrationNewCourse {
    private final FindCourseByName findCourseByName;
    private final CourseRepository courseRepository;

    @Override
    public NewCourseDtoExit execute(NewCourseDtoEntrance newCourseDtoEntrance) {
        //necesito validar que el curso no vaya a estar repetido
        Long courseBd = findCourseByName.execute(newCourseDtoEntrance.nameCourse());
        if (courseBd != null) {
            throw new CourseAlreadyExistsException(newCourseDtoEntrance.nameCourse());
        }

        Course course = CourseAppMapper.toDomain(newCourseDtoEntrance);

        Course savedCourse = courseRepository.save(course);

        return CourseAppMapper.toDto(savedCourse);
    }
}
