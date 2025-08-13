package com.alura.foroHub.application.UseCase.topic;

import com.alura.foroHub.application.dto.topic.ShowAllTopicsDtoExit;
import com.alura.foroHub.application.exception.TopicNotFoundException;
import com.alura.foroHub.application.mapper.TopicAppMapper;
import com.alura.foroHub.domain.model.Topic;
import com.alura.foroHub.domain.repository.TopicRepository;
import com.alura.foroHub.domain.useCases.topic.ShowAllTopics;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class ShowAllTopicsImpl implements ShowAllTopics {

    private final TopicRepository topicRepository;

    @Override
    public List<ShowAllTopicsDtoExit> execute() {

        List<Topic> topics = topicRepository.findAll();
        if (topics.isEmpty()) {
            throw new TopicNotFoundException();

        }


        return topics.stream()
                .map(TopicAppMapper::toDto)
                .collect(Collectors.toList());

    }

}
