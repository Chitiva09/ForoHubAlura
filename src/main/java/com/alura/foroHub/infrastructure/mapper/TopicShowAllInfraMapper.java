package com.alura.foroHub.infrastructure.mapper;

import com.alura.foroHub.domain.model.Course;
import com.alura.foroHub.domain.model.Topic;
import com.alura.foroHub.infrastructure.entity.TopicEntity;

import java.util.List;
import java.util.stream.Collectors;

public class TopicShowAllInfraMapper {

    public Topic toDomain ( TopicEntity topicEntity){
    Topic topic = new Topic();

        topic.setId(topicEntity.getId());
        topic.setTitle(topicEntity.getTitle());
        topic.setMessage(topicEntity.getMessage());
        topic.setCreationDate(topicEntity.getCreationDate());
        topic.setStatus(topicEntity.isStatus());
        topic.setAuthor(topicEntity.getAuthor());

        topic.setCourse( new Course(
                            topicEntity.getCourseEntity().getId(),
                            topicEntity.getCourseEntity().getNameCourse(),
                            topicEntity.getCourseEntity().getCategory())
        );

        return topic;
    }


    //este metodo lo uso para devolver un list al domain
    public List<Topic> toDomainList (List<TopicEntity> topicEntityList){

    return topicEntityList.stream()
            .map(this::toDomain)
            .collect(Collectors.toList());
    }

}
