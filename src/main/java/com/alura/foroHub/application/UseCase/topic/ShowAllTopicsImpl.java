package com.alura.foroHub.application.UseCase.topic;

import com.alura.foroHub.application.dto.topic.ShowAllTopicsDtoExit;
import com.alura.foroHub.application.exception.topic.TopicNotFoundException;
import com.alura.foroHub.application.mapper.TopicAppMapper;
import com.alura.foroHub.domain.model.Topic;
import com.alura.foroHub.domain.repository.TopicRepository;
import com.alura.foroHub.domain.useCases.topic.ShowAllTopics;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@RequiredArgsConstructor
public class ShowAllTopicsImpl implements ShowAllTopics {

    private final TopicRepository topicRepository;

    @Override
    public Page<ShowAllTopicsDtoExit> execute(Pageable pageable) {

        Page<Topic> topics = topicRepository.findAll(pageable);

        if (topics.isEmpty()) {
            throw new TopicNotFoundException();

        }

        return topics.map(TopicAppMapper::toDto);

    }

}
