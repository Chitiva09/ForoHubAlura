package com.alura.foroHub.application.mapper;

import java.time.LocalDateTime;

import com.alura.foroHub.application.dto.NewTopicDtoEntrance;
import com.alura.foroHub.application.dto.ShowAllTopicsDtoExit;
import com.alura.foroHub.domain.model.Course;
import com.alura.foroHub.domain.model.Topic;


public class TopicAppMapper {

    public Topic toModel(NewTopicDtoEntrance newTopicDtoEntrance, Long courseId){

        Topic topic = new Topic();
        topic.setTitle(newTopicDtoEntrance.title());
        topic.setMessage(newTopicDtoEntrance.message());
        topic.setCreationDate(LocalDateTime.now());
        topic.setAuthor(newTopicDtoEntrance.author());
        topic.setStatus(true);

        Course course = new Course();
        course.setId(courseId);
        topic.setCourse(course);
    return topic;
    }

    public ShowAllTopicsDtoExit toDto(Topic topic){
        return new ShowAllTopicsDtoExit(
                topic.getTitle(),
                topic.getMessage(),
                topic.getAuthor(),
                topic.getCourse() != null ? topic.getCourse().getNameCourse() : "",
                topic.getCourse() != null ? topic.getCourse().getId() : null
        );

    }

}
