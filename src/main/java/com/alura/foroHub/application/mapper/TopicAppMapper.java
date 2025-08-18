package com.alura.foroHub.application.mapper;


import com.alura.foroHub.application.dto.topic.CreateTopicDtoExit;
import com.alura.foroHub.application.dto.topic.NewTopicDtoEntrance;
import com.alura.foroHub.application.dto.topic.ShowAllTopicsDtoExit;
import com.alura.foroHub.application.dto.topic.TopicsByIdDtoExit;
import com.alura.foroHub.domain.model.Course;
import com.alura.foroHub.domain.model.Topic;
import com.alura.foroHub.domain.valueObject.topic.AuthorVO;
import com.alura.foroHub.domain.valueObject.topic.CreationDateVO;
import com.alura.foroHub.domain.valueObject.topic.MessageVO;
import com.alura.foroHub.domain.valueObject.topic.TitleVO;

import java.util.Optional;


public class TopicAppMapper {

    public static Topic toModel(NewTopicDtoEntrance newTopicDtoEntrance, Course course) {
        return Topic.builder()
                .withTitle(new TitleVO(newTopicDtoEntrance.title()))
                .withMessage(new MessageVO(newTopicDtoEntrance.message()))
                .withAuthor(new AuthorVO(newTopicDtoEntrance.author()))
                .withCreationDate(CreationDateVO.now())
                .withCourse(course)
                .build();
    }

    public static Topic toUpdateModel(Topic existingTopic, NewTopicDtoEntrance dtoEntrance, Course course) {
        return existingTopic.toBuilder()
                .withTitle(new TitleVO(dtoEntrance.title()))
                .withMessage(new MessageVO(dtoEntrance.message()))
                .withAuthor(new AuthorVO(dtoEntrance.author()))
                .withCourse(course)
                .build();
    }

    public static ShowAllTopicsDtoExit toDto(Topic topic) {
        return new ShowAllTopicsDtoExit(
                topic.getId(),
                topic.getTitle().getTitle(),
                topic.getMessage().getMessage(),
                topic.getCreationDate().getCreationDate(),
                topic.isStatus() ? "Activo" : "Inactivo",
                topic.getAuthor().getAuthor(),
                topic.getCourse().getNameCourse().getNameCourse(),
                topic.getCourse().getId()
        );
    }

    public static TopicsByIdDtoExit topicsByIdDtoExit(Topic topic) {
        return new TopicsByIdDtoExit(
                topic.getId(),
                topic.getTitle().getTitle(),
                topic.getMessage().getMessage(),
                topic.getCreationDate().getCreationDate(),
                String.valueOf(topic.isStatus()),
                topic.getAuthor().getAuthor(),
                topic.getCourse().getNameCourse().getNameCourse()
        );
    }

    public static CreateTopicDtoExit toCreateTopicDtoExit(Topic topic) {

        return new CreateTopicDtoExit(
                topic.getTitle().getTitle(),
                topic.getMessage().getMessage(),
                topic.getAuthor().getAuthor(),
                topic.getId()
        );


    }
}
