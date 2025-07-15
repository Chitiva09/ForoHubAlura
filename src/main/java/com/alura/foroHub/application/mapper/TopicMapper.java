package com.alura.foroHub.application.mapper;

import com.alura.foroHub.application.dto.NewTopicDtoEntrance;
import com.alura.foroHub.infrastructure.entity.CourseEntity;
import com.alura.foroHub.infrastructure.entity.TopicEntity;

import java.time.LocalDateTime;


public class TopicMapper {

    public TopicEntity toEntity(NewTopicDtoEntrance newTopicDtoEntrance, CourseEntity courseEntityName){

        TopicEntity topicEntity = new TopicEntity();
        topicEntity.setTitle(newTopicDtoEntrance.title());
        topicEntity.setMessage(newTopicDtoEntrance.message());
        topicEntity.setCreationDate(LocalDateTime.now());
        topicEntity.setAuthor(newTopicDtoEntrance.author());
        topicEntity.setStatus(true);
        topicEntity.setCourseEntity(courseEntityName);

    return topicEntity;
    }

}
