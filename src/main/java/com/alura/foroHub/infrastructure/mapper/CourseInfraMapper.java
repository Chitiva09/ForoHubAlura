package com.alura.foroHub.infrastructure.mapper;


import com.alura.foroHub.domain.model.Course;
import com.alura.foroHub.infrastructure.entity.CourseEntity;
import org.springframework.stereotype.Component;

@Component
public class CourseInfraMapper {
    public Course toDomain (CourseEntity courseEntity){
        if (courseEntity == null ){
            return null;
        }

        return new Course(courseEntity.getId(), courseEntity.getNameCourse(),courseEntity.getCategory());
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
