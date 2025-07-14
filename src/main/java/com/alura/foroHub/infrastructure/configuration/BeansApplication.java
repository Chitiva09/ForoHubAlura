package com.alura.foroHub.infrastructure.configuration;

import com.alura.foroHub.application.UseCase.TopicUseCase;
import com.alura.foroHub.application.UseCase.TopicUseCaseImpl;
import com.alura.foroHub.application.mapper.TopicMapper;
import com.alura.foroHub.domain.repository.CourseRepository;
import com.alura.foroHub.domain.repository.TopicRepository;
import com.alura.foroHub.infrastructure.repository.course.CourseRepositoryJpa;
import com.alura.foroHub.infrastructure.repository.course.CourseRepositoryJpaImpl;
import com.alura.foroHub.infrastructure.repository.topic.TopicRepositoryJpa;
import com.alura.foroHub.infrastructure.repository.topic.TopicRepositoryJpaImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeansApplication {

    @Bean
    public TopicRepository topicRepository (TopicRepositoryJpa jpa){

        return new TopicRepositoryJpaImpl(jpa);
    }

    @Bean
    public CourseRepository courseRepository (CourseRepositoryJpa jpa){

        return new CourseRepositoryJpaImpl(jpa);
    }

    @Bean
    public TopicUseCase topicUseCase (TopicMapper topicMapper, TopicRepository topicrepository, CourseRepository courseRepository ){

        return new TopicUseCaseImpl(topicMapper,topicrepository,courseRepository );
    }
}
