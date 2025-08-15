package com.alura.foroHub.infrastructure.mapper;


import com.alura.foroHub.domain.model.Course;
import com.alura.foroHub.domain.valueObject.course.CategoryVO;
import com.alura.foroHub.domain.valueObject.course.NameCourseVO;
import com.alura.foroHub.infrastructure.entity.CourseEntity;


public class CourseInfraMapper {
    public static Course toDomain (CourseEntity courseEntity){
        return new Course(
                courseEntity.getId(),
                new NameCourseVO(courseEntity.getNameCourse()),
                new CategoryVO(courseEntity.getCategory()));
    }




    public static CourseEntity toEntityId (Long idCourse){
        CourseEntity courseEntity= new CourseEntity();
        courseEntity.setId(idCourse);
        return courseEntity;
    }

    public static CourseEntity toEntity (Course course){
        return CourseEntity.builder()
                .nameCourse(course.getNameCourse().getNameCourse())
                .category(course.getCategory().getCategory())
                .build();
    }
}
