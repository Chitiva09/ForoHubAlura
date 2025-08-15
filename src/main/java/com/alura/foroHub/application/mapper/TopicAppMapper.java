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


public class TopicAppMapper {

    public static Topic toModel(NewTopicDtoEntrance newTopicDtoEntrance) {
        return Topic.builder()
                .withTitle(new TitleVO(newTopicDtoEntrance.title()))
                .withMessage(new MessageVO(newTopicDtoEntrance.message()))
                .withAuthor(new AuthorVO(newTopicDtoEntrance.author()))
                .withCreationDate(CreationDateVO.now())
                .withCourse(Course.builder()
                        .withId(newTopicDtoEntrance.courseId())
                        .build())


                .build();


    }

    public static ShowAllTopicsDtoExit toDto(Topic topic) {
        return new ShowAllTopicsDtoExit(
                topic.getTitle().getTitle(),
                topic.getMessage().getMessage(),
                topic.getAuthor().getAuthor(),
                topic.getCourse().getNameCourse().getNameCourse(),
                topic.getCourse().getId()
        );
    }

    public static TopicsByIdDtoExit topicsByIdDtoExit(Topic topic) {
        return new TopicsByIdDtoExit(
                topic.getTitle().getTitle(),
                topic.getMessage().getMessage(),
                topic.getCreationDate().getCreationDate(),
                String.valueOf(topic.isStatus()),
                topic.getAuthor().getAuthor(),
                topic.getCourse().getNameCourse().getNameCourse()
        );
    }

    public static CreateTopicDtoExit toCreateTopicDtoExit(Topic topic){

        return new CreateTopicDtoExit(
                topic.getTitle().getTitle(),
                topic.getMessage().getMessage(),
                topic.getAuthor().getAuthor(),
                topic.getId()
        );


    }
}
