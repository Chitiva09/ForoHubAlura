package com.alura.foroHub.application.mapper;

import java.time.LocalDateTime;

import com.alura.foroHub.application.dto.NewTopicDtoEntrance;
import com.alura.foroHub.application.dto.ShowAllTopicsDtoExit;
import com.alura.foroHub.domain.model.Course;
import com.alura.foroHub.domain.model.Topic;
import com.alura.foroHub.domain.valueObject.topic.AuthorVO;
import com.alura.foroHub.domain.valueObject.topic.MessageVO;
import com.alura.foroHub.domain.valueObject.topic.TitleVO;


public class TopicAppMapper {

    public Topic toModel(NewTopicDtoEntrance newTopicDtoEntrance, Long  courseId){
        return Topic.builder()
                .withTitle(new TitleVO(newTopicDtoEntrance.title()))
                .withMessage(new MessageVO(newTopicDtoEntrance.message()))
                .withAuthor(new AuthorVO(newTopicDtoEntrance.author()))
                .withCourse(Course.builder().withId(courseId).build())


                .build();



    }

    public ShowAllTopicsDtoExit toDto(Topic topic){
        return new ShowAllTopicsDtoExit(
                topic.getTitle().getTitle(),
                topic.getMessage().getMessage(),
                topic.getAuthor().getAuthor(),
                topic.getCourse().getNameCourse().getNameCourse(),
                topic.getCourse().getId()
        );
    }

}
