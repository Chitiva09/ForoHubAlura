package com.alura.foroHub.application.mapper;

import com.alura.foroHub.application.dto.TopicDto;
import com.alura.foroHub.domain.model.Topic;

public class TopicMapper {

    public Topic toEntity(TopicDto topicDto){
        Topic topic = new Topic();

        topic.setTitle(topicDto.title());
        topic.setMessage(topicDto.message());
        topic.setCreationDate(topicDto.creationDate());
        topic.setStatus(topicDto.status());
        topic.setAuthor(String.valueOf(topicDto.author()));

    return topic;
    }

    public TopicDto toDto (Topic topic){
        TopicDto topicDto = new TopicDto(
                topic.getTitle(),
                topic.getMessage(),
                topic.getCreationDate(),
                topic.isStatus(),
                topic.getAuthor(),
                topic.getCourse().getNameCourse()

        );

    }
}
