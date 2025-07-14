package com.alura.foroHub.infrastructure.mapper;

import com.alura.foroHub.domain.model.Course;
import com.alura.foroHub.domain.model.Topic;

import java.time.LocalDateTime;

public class TopicInfraMapper {

    public Topic toEntity (Topic topic, Course courseName){
        Topic newTopic = new Topic();

        newTopic.setTitle(topic.getTitle());
        newTopic.setMessage(topic.getMessage());
        newTopic.setCreationDate(LocalDateTime.now());
        newTopic.setAuthor(topic.getAuthor());
        newTopic.setStatus(true);
        newTopic.setCourse(courseName);

        return newTopic;

    }



}
