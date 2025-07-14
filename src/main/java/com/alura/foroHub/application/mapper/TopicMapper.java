package com.alura.foroHub.application.mapper;

import com.alura.foroHub.application.dto.NewTopicDtoEntrance;
import com.alura.foroHub.domain.model.Course;
import com.alura.foroHub.domain.model.Topic;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;


public class TopicMapper {

    public Topic toEntity(NewTopicDtoEntrance newTopicDtoEntrance, Course courseName){

        Topic topic = new Topic();
        topic.setTitle(newTopicDtoEntrance.title());
        topic.setMessage(newTopicDtoEntrance.message());
        topic.setCreationDate(LocalDateTime.now());
        topic.setAuthor(newTopicDtoEntrance.author());
        topic.setStatus(true);
        topic.setCourse(courseName);

    return topic;
    }

}
