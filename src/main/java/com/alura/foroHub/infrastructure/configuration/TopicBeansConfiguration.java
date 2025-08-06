package com.alura.foroHub.infrastructure.configuration;

import com.alura.foroHub.application.UseCase.RegistrationNewTopicImpl;
import com.alura.foroHub.application.UseCase.SearchTopicByIdImpl;
import com.alura.foroHub.application.UseCase.ShowAllTopicsImpl;
import com.alura.foroHub.application.mapper.TopicAppMapper;
import com.alura.foroHub.domain.repository.TopicRepository;
import com.alura.foroHub.domain.useCases.FindCourseByName;
import com.alura.foroHub.domain.useCases.RegistrationNewTopic;
import com.alura.foroHub.domain.useCases.SearchTopicById;
import com.alura.foroHub.domain.useCases.ShowAllTopics;
import com.alura.foroHub.infrastructure.mapper.TopicInfraMapper;
import com.alura.foroHub.infrastructure.persistence.topic.TopicRepositoryJpa;
import com.alura.foroHub.infrastructure.persistence.topic.TopicRepositoryJpaAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TopicBeansConfiguration {


    @Bean
    public TopicRepository topicRepository (TopicRepositoryJpa jpa ){

        return new TopicRepositoryJpaAdapter(jpa);
    }
    @Bean
    public RegistrationNewTopic topicUseCase (TopicRepository topicrepository, FindCourseByName findCourseByName){

        return new RegistrationNewTopicImpl(topicrepository,findCourseByName );
    }

    @Bean
    public SearchTopicById searchTopicById (TopicRepository topicRepository){
        return new SearchTopicByIdImpl(topicRepository);
    }

    @Bean
    public TopicInfraMapper topicInfraMapper() {
        return new TopicInfraMapper();
    }



    @Bean
    public TopicAppMapper topicAppMapper() {
        return new TopicAppMapper();
    }

    @Bean
    public ShowAllTopics showAllTopicsUseCase (TopicRepository topicRepository){
        return new ShowAllTopicsImpl(topicRepository);
    }
}
