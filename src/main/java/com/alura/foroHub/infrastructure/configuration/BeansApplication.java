package com.alura.foroHub.infrastructure.configuration;


import com.alura.foroHub.application.UseCase.ShowAllTopicsImpl;
import com.alura.foroHub.application.mapper.CourseAppMapper;
import com.alura.foroHub.domain.useCases.ShowAllTopics;
import com.alura.foroHub.infrastructure.persistence.course.CourseRepositoryJpa;
import com.alura.foroHub.infrastructure.persistence.course.CourseRepositoryJpaAdapter;
import com.alura.foroHub.infrastructure.persistence.topic.TopicRepositoryJpa;
import com.alura.foroHub.infrastructure.persistence.topic.TopicRepositoryJpaAdapter;
import com.alura.foroHub.application.UseCase.FindCourseByNameImpl;
import com.alura.foroHub.application.UseCase.RegistrationNewTopicImpl;
import com.alura.foroHub.application.mapper.TopicAppMapper;
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
    public TopicRepository topicRepository (TopicRepositoryJpa jpa, TopicInfraMapper topicInfraMapper, CourseInfraMapper courseInfraMapper ){

        return new TopicRepositoryJpaAdapter(jpa, topicInfraMapper, courseInfraMapper);
    }

    @Bean
    public CourseRepository courseRepository (CourseRepositoryJpa jpa, CourseInfraMapper courseInfraMapper){

        return new CourseRepositoryJpaAdapter(jpa, courseInfraMapper);
    }

    @Bean
    public RegistrationNewTopic topicUseCase (TopicAppMapper topicAppMapper,
                                            TopicRepository topicrepository,
                                            FindCourseByName findCourseByName){

        return new RegistrationNewTopicImpl(topicAppMapper,topicrepository,findCourseByName );
    }

    @Bean
    public TopicInfraMapper topicInfraMapper() {
        return new TopicInfraMapper();
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
    public TopicAppMapper topicAppMapper() {
        return new TopicAppMapper();
    }

    @Bean
    public ShowAllTopics showAllTopicsUseCase (TopicRepository topicRepository,TopicAppMapper topicAppMapper){
        return new ShowAllTopicsImpl(topicRepository, topicAppMapper);
    }

    @Bean
    public FindCourseByName findCourseByName (CourseRepository courseRepository){

        return new FindCourseByNameImpl(courseRepository);
    }
}
