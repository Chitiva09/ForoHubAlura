package com.alura.foroHub.infrastructure.configuration;

import com.alura.foroHub.application.UseCase.FindCourseByNameImpl;
import com.alura.foroHub.application.mapper.CourseAppMapper;
import com.alura.foroHub.domain.repository.CourseRepository;
import com.alura.foroHub.domain.useCases.FindCourseByName;
import com.alura.foroHub.infrastructure.mapper.CourseInfraMapper;
import com.alura.foroHub.infrastructure.persistence.course.CourseRepositoryJpa;
import com.alura.foroHub.infrastructure.persistence.course.CourseRepositoryJpaAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CourseBeansConfiguration {

    @Bean
    public CourseRepository courseRepository (CourseRepositoryJpa jpa){

        return new CourseRepositoryJpaAdapter(jpa);
    }

    @Bean
    public CourseInfraMapper courseInfraMapper() {
        return new CourseInfraMapper();
    }

    @Bean
    public CourseAppMapper courseAppMapper() {
        return new CourseAppMapper();
    }
    @Bean
    public FindCourseByName findCourseByName (CourseRepository courseRepository){

        return new FindCourseByNameImpl(courseRepository);
    }
}
