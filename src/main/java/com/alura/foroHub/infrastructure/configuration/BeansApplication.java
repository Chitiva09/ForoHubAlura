package com.alura.foroHub.infrastructure.configuration;

import com.alura.foroHub.application.UseCase.TopicUseCase;
import com.alura.foroHub.application.UseCase.TopicUseCaseImpl;
import com.alura.foroHub.domain.repository.CourseRepository;
import com.alura.foroHub.domain.repository.TopicRepository;
import com.alura.foroHub.infrastructure.repository.topic.TopicRepositoryJpa;
import com.alura.foroHub.infrastructure.repository.topic.TopicRepositoryJpaImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeansApplication {

    @Bean
    public TopicRepository topicRepository (TopicRepositoryJpaImpl jpa){

        return new TopicRepositoryJpa(jpa);
    }

    public TopicUseCase topicUseCase (TopicRepository repository, CourseRepository courseRepository, String courseName){

        return new TopicUseCaseImpl(repository,courseRepository, courseName);
    }
}
