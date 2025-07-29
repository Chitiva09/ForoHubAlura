package com.alura.foroHub.infrastructure.configuration;


import com.alura.foroHub.application.mapper.FindByNameCourseAppMapper;
import com.alura.foroHub.infrastructure.mapper.TopicShowAllInfraMapper;
import com.alura.foroHub.infrastructure.persistence.course.CourseRepositoryJpa;
import com.alura.foroHub.infrastructure.persistence.course.CourseRepositoryJpaAdapter;
import com.alura.foroHub.infrastructure.persistence.topic.TopicRepositoryJpa;
import com.alura.foroHub.infrastructure.persistence.topic.TopicRepositoryJpaAdapter;
import com.alura.foroHub.application.UseCase.FindCourseByNameImpl;
import com.alura.foroHub.application.UseCase.RegistrationNewTopicImpl;
import com.alura.foroHub.application.mapper.NewTopicAppMapper;
import com.alura.foroHub.domain.repository.CourseRepository;
import com.alura.foroHub.domain.repository.TopicRepository;
import com.alura.foroHub.domain.useCases.FindCourseByName;
import com.alura.foroHub.domain.useCases.RegistrationNewTopic;
import com.alura.foroHub.infrastructure.mapper.FindByNameCourseInfraMapper;
import com.alura.foroHub.infrastructure.mapper.NewTopicInfraMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class BeansApplication {

    @Bean
    @Primary
    public TopicRepository topicRepository (TopicRepositoryJpa jpa, NewTopicInfraMapper newTopicInfraMapper, FindByNameCourseInfraMapper findByNameCourseInfraMapper, TopicShowAllInfraMapper topicShowAllInfraMapper){

        return new TopicRepositoryJpaAdapter(jpa, newTopicInfraMapper, findByNameCourseInfraMapper, topicShowAllInfraMapper);
    }

    @Bean
    public CourseRepository courseRepository (CourseRepositoryJpa jpa, FindByNameCourseInfraMapper findByNameCourseInfraMapper){

        return new CourseRepositoryJpaAdapter(jpa, findByNameCourseInfraMapper);
    }
    
    @Bean
    public NewTopicAppMapper topicMapper(){

        return new NewTopicAppMapper();
    }

    @Bean
    public FindByNameCourseAppMapper courseDomainMapper(){
        return new FindByNameCourseAppMapper();
    }

    @Bean
    public NewTopicInfraMapper topicInfraMapper(){
        return new NewTopicInfraMapper();
    }
    @Bean
    public FindByNameCourseInfraMapper courseInfraMapper(){
        return new FindByNameCourseInfraMapper();
    }

    @Bean
    public RegistrationNewTopic topicUseCase (NewTopicAppMapper newTopicAppMapper,
                                              TopicRepository topicrepository,
                                              FindCourseByName findCourseByName){

        return new RegistrationNewTopicImpl(newTopicAppMapper,topicrepository,findCourseByName );
    }

    @Bean
    public FindCourseByName findCourseByName (CourseRepository courseRepository){

        return new FindCourseByNameImpl(courseRepository);
    }
}
