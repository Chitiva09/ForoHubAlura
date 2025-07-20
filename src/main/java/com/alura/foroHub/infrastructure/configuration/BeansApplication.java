package com.alura.foroHub.infrastructure.configuration;

import com.alura.foroHub.application.UseCase.registrationNewTopicUseCase.RegistrationNewTopic;
import com.alura.foroHub.application.UseCase.registrationNewTopicUseCase.RegistrationNewTopicImpl;
import com.alura.foroHub.application.mapper.TopicMapper;
import com.alura.foroHub.domain.repository.CourseRepository;
import com.alura.foroHub.domain.repository.TopicRepository;
import com.alura.foroHub.infrastructure.mapper.CourseInfraMapper;
import com.alura.foroHub.infrastructure.mapper.TopicInfraMapper;
import com.alura.foroHub.infrastructure.repository.course.CourseRepositoryJpa;
import com.alura.foroHub.infrastructure.repository.course.CourseRepositoryJpaImpl;
import com.alura.foroHub.infrastructure.repository.topic.TopicRepositoryJpa;
import com.alura.foroHub.infrastructure.repository.topic.TopicRepositoryJpaImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeansApplication {

    @Bean
    public TopicRepository topicRepository (TopicRepositoryJpa jpa, TopicInfraMapper topicInfraMapper, CourseInfraMapper courseInfraMapper){

        return new TopicRepositoryJpaImpl(jpa, topicInfraMapper, courseInfraMapper);
    }

    @Bean
    public CourseRepository courseRepository (CourseRepositoryJpa jpa, CourseInfraMapper courseInfraMapper){

        return new CourseRepositoryJpaImpl(jpa, courseInfraMapper);
    }
    @Bean
    public TopicMapper topicMapper(){

        return new TopicMapper();
    }

    @Bean
    public RegistrationNewTopic topicUseCase (TopicMapper topicMapper, TopicRepository topicrepository, CourseRepository courseRepository ){

        return new RegistrationNewTopicImpl(topicMapper,topicrepository,courseRepository );
    }
}
