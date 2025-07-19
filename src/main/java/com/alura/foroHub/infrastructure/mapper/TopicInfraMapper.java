package com.alura.foroHub.infrastructure.mapper;

import com.alura.foroHub.domain.model.Course;
import com.alura.foroHub.domain.model.Topic;
import com.alura.foroHub.infrastructure.entity.CourseEntity;
import com.alura.foroHub.infrastructure.entity.TopicEntity;

import java.time.LocalDateTime;

public class TopicInfraMapper {
// De modelo de dominio a entidad de infraestructura JPA
    public TopicEntity toEntity (Topic topic, CourseEntity courseEntity){
        TopicEntity newTopicEntity = new TopicEntity();

        newTopicEntity.setTitle(topic.getTitle());
        newTopicEntity.setMessage(topic.getMessage());
        newTopicEntity.setCreationDate(LocalDateTime.now());
        newTopicEntity.setAuthor(topic.getAuthor());
        newTopicEntity.setStatus(true);
        newTopicEntity.setCourseEntity(courseEntity);

        return newTopicEntity;

    }

//De entidad de infraestructura JPA a modelo de dominio
public Topic toModel(TopicEntity topicEntity){

    


}
