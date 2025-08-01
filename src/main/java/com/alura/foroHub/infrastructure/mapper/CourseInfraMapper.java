package com.alura.foroHub.infrastructure.mapper;


import com.alura.foroHub.domain.model.Course;
import com.alura.foroHub.domain.valueObject.course.CategoryVO;
import com.alura.foroHub.domain.valueObject.course.NameCourseVO;
import com.alura.foroHub.infrastructure.entity.CourseEntity;


public class CourseInfraMapper {
    public Course toDomain (CourseEntity courseEntity){
        if (courseEntity == null ){
            return null;
        }

        return new Course(
                courseEntity.getId(),
                new NameCourseVO(courseEntity.getNameCourse()),
                new CategoryVO(courseEntity.getCategory()));
    }




    public CourseEntity toEntity (Long idCourse){
        if (idCourse == null){
            return null;
        }
        CourseEntity courseEntity= new CourseEntity();
        courseEntity.setId(idCourse);;
        return courseEntity;
    }
}
