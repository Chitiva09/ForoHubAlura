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
        topic.setAuthor(topicDto.author());


    }
}
