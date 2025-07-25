package com.alura.foroHub.infrastructure.configuration;


import com.alura.foroHub.application.mapper.CourseDomainMapper;
import com.alura.foroHub.infrastructure.persistence.course.CourseRepositoryJpa;
import com.alura.foroHub.infrastructure.persistence.course.CourseRepositoryJpaAdapter;
import com.alura.foroHub.infrastructure.persistence.topic.TopicRepositoryJpa;
import com.alura.foroHub.infrastructure.persistence.topic.TopicRepositoryJpaAdapter;
import com.alura.foroHub.application.UseCase.findCourseByNameUseCase.FindCourseByNameImpl;
import com.alura.foroHub.application.UseCase.registrationNewTopicUseCase.RegistrationNewTopicImpl;
import com.alura.foroHub.application.mapper.TopicMapper;
import com.alura.foroHub.domain.repository.CourseRepository;
import com.alura.foroHub.domain.repository.TopicRepository;
import com.alura.foroHub.domain.useCases.FindCourseByName;
import com.alura.foroHub.domain.useCases.RegistrationNewTopic;
import com.alura.foroHub.infrastructure.mapper.CourseInfraMapper;
import com.alura.foroHub.infrastructure.mapper.TopicInfraMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class BeansApplication {

    @Bean
    @Primary
    public TopicRepository topicRepository (TopicRepositoryJpa jpa, TopicInfraMapper topicInfraMapper, CourseInfraMapper courseInfraMapper){

        return new TopicRepositoryJpaAdapter(jpa, topicInfraMapper, courseInfraMapper);
    }

    @Bean
    public CourseRepository courseRepository (CourseRepositoryJpa jpa, CourseInfraMapper courseInfraMapper){

        return new CourseRepositoryJpaAdapter(jpa, courseInfraMapper);
    }
    
    @Bean
    public TopicMapper topicMapper(){

        return new TopicMapper();
    }

    @Bean
    public CourseDomainMapper courseDomainMapper(){
        return new CourseDomainMapper();
    }

    @Bean
    public TopicInfraMapper topicInfraMapper(){
        return new TopicInfraMapper();
    }
    @Bean
    public CourseInfraMapper courseInfraMapper(){
        return new CourseInfraMapper();
    }

    @Bean
    public RegistrationNewTopic topicUseCase (TopicMapper topicMapper,
                                              TopicRepository topicrepository,
                                              FindCourseByName findCourseByName){

        return new RegistrationNewTopicImpl(topicMapper,topicrepository,findCourseByName );
    }

    @Bean
    public FindCourseByName findCourseByName (CourseRepository courseRepository){

        return new FindCourseByNameImpl(courseRepository);
    }
}
