package com.alura.foroHub.infrastructure.mapper;

import com.alura.foroHub.domain.model.Course;
import com.alura.foroHub.domain.model.Topic;
import com.alura.foroHub.infrastructure.entity.CourseEntity;
import com.alura.foroHub.infrastructure.entity.TopicEntity;

import java.time.LocalDateTime;

public class TopicInfraMapper {

    public TopicEntity toEntity (Topic topic, Course courseName){
        TopicEntity newTopicEntity = new TopicEntity();

        newTopicEntity.setTitle(topic.getTitle());
        newTopicEntity.setMessage(topic.getMessage());
        newTopicEntity.setCreationDate(LocalDateTime.now());
        newTopicEntity.setAuthor(topic.getAuthor());
        newTopicEntity.setStatus(true);
        newTopicEntity.setCourseEntity(courseName.getNameCourse());

        return newTopicEntity;

    }




}
