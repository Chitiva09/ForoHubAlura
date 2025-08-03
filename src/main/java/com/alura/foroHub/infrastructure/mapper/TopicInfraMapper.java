package com.alura.foroHub.infrastructure.mapper;

import com.alura.foroHub.domain.model.Course;
import com.alura.foroHub.domain.model.Topic;
import com.alura.foroHub.domain.valueObject.course.CategoryVO;
import com.alura.foroHub.domain.valueObject.course.NameCourseVO;
import com.alura.foroHub.domain.valueObject.topic.AuthorVO;
import com.alura.foroHub.domain.valueObject.topic.CreationDateVO;
import com.alura.foroHub.domain.valueObject.topic.MessageVO;
import com.alura.foroHub.domain.valueObject.topic.TitleVO;
import com.alura.foroHub.infrastructure.entity.CourseEntity;
import com.alura.foroHub.infrastructure.entity.TopicEntity;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


public class TopicInfraMapper {

    // De modelo de dominio a entidad de infraestructuraJPA
    public static TopicEntity toEntity(Topic topic, CourseEntity courseEntity) {
        return TopicEntity.builder()
                .title(topic.getTitle().getTitle())
                .message(topic.getMessage().getMessage())
                .creationDate(topic.getCreationDate().getCreationDate())
                .status(topic.isStatus())
                .courseEntity(courseEntity)
                .build();
    }

    // De entidad de infraestructuraJPA a modelo de dominio
    //Este metodo usa el patron builder para hacer un código más limpio pero con la misma intention de un TopicEntity para el Topic de domain
    public static Topic toDomain ( TopicEntity topicEntity){

        Topic.TopicBuilder topicBuilder = Topic.builder()
                .withId(topicEntity.getId())
                .withTitle(new TitleVO(topicEntity.getTitle()))
                .withMessage( new MessageVO(topicEntity.getMessage()))
                .withCreationDate(new CreationDateVO(topicEntity.getCreationDate()))
                .withStatus(topicEntity.isStatus())
                .withAuthor(new AuthorVO(topicEntity.getAuthor()));

        topicBuilder.withCourse( Course.builder()
                        .withId(topicEntity.getCourseEntity().getId())
                        .withNameCourse(new NameCourseVO(topicEntity.getCourseEntity().getNameCourse()))
                        .withCategory(new CategoryVO(topicEntity.getCourseEntity().getCategory()))
                        .build())
                .build();
        return topicBuilder.build();
    }


    //este metodo lo uso para devolver un list al domain
    public static List<Topic> toDomainList(List<TopicEntity> topicEntityList){

        return topicEntityList.stream()
                .map(TopicInfraMapper::toDomain)
                .collect(Collectors.toList());
    }


    public static Topic searchByIdToDomain (TopicEntity topicEntity){

        // DEBO IMPLEMENTAR EL MAPPER ACA VA EL FLUJO DEL ENDPOINT QUE ESTOY TERMINANDO
    }
}