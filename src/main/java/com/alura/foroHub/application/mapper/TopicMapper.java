package com.alura.foroHub.application.mapper;

import java.time.LocalDateTime;

import com.alura.foroHub.application.dto.NewTopicDtoEntrance;
import com.alura.foroHub.domain.model.Course;
import com.alura.foroHub.domain.model.Topic;


public class TopicMapper {

    public Topic toModel(NewTopicDtoEntrance newTopicDtoEntrance, String courseId){

        Topic topic = new Topic();
        topic.setTitle(newTopicDtoEntrance.title());
        topic.setMessage(newTopicDtoEntrance.message());
        topic.setCreationDate(LocalDateTime.now());
        topic.setAuthor(newTopicDtoEntrance.author());
        topic.setStatus(true);
        topic.setCourse(courseId);
    return topic;
    }

}
