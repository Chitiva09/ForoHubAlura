package com.alura.foroHub.infrastructure.mapper;

import com.alura.foroHub.domain.model.Course;
import com.alura.foroHub.domain.model.Topic;
import com.alura.foroHub.infrastructure.entity.CourseEntity;
import com.alura.foroHub.infrastructure.entity.TopicEntity;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;


public class TopicInfraMapper {
    // De modelo de dominio a entidad de infraestructuraJPA
    public TopicEntity toEntity(Topic topic, CourseEntity courseEntity) {
        TopicEntity newTopicEntity = new TopicEntity();

        newTopicEntity.setTitle(topic.getTitle());
        newTopicEntity.setMessage(topic.getMessage());
        newTopicEntity.setCreationDate(topic.getCreationDate());
        newTopicEntity.setAuthor(topic.getAuthor());
        newTopicEntity.setStatus(true);
        newTopicEntity.setCourseEntity(courseEntity);

        return newTopicEntity;

    }

    // De entidad de infraestructuraJPA a modelo de dominio
    public Topic toModel(TopicEntity topicEntity) {

        Topic newTopicModel = new Topic();

        newTopicModel.setId(topicEntity.getId());
        newTopicModel.setTitle(topicEntity.getTitle());
        newTopicModel.setMessage(topicEntity.getMessage());
        newTopicModel.setCreationDate(topicEntity.getCreationDate());
        newTopicModel.setAuthor(topicEntity.getAuthor());
        newTopicModel.setStatus(topicEntity.isStatus());
        newTopicModel.setCourse(new Course(
                topicEntity.getCourseEntity().getId(),
                topicEntity.getCourseEntity().getNameCourse(),
                topicEntity.getCourseEntity().getCategory()));

        return newTopicModel;
    }
}