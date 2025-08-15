package com.alura.foroHub.application.mapper;

import com.alura.foroHub.application.dto.course.NewCourseDtoEntrance;
import com.alura.foroHub.application.dto.course.NewCourseDtoExit;
import com.alura.foroHub.domain.model.Course;
import com.alura.foroHub.domain.valueObject.course.CategoryVO;
import com.alura.foroHub.domain.valueObject.course.NameCourseVO;

public class CourseAppMapper {

    public static Course toDomain(NewCourseDtoEntrance dtoEntrance) {

        return Course.builder()
                .withNameCourse(new NameCourseVO(dtoEntrance.nameCourse()))
                .withCategory(new CategoryVO(dtoEntrance.category()))
                .build();
    }

    public static NewCourseDtoExit toDto (Course course){

        return new NewCourseDtoExit(
                course.getId(),
                course.getNameCourse().getNameCourse(),
                course.getCategory().getCategory()
        );

    }

}
