package com.alura.foroHub.application.UseCase.topic;

import com.alura.foroHub.application.dto.topic.TopicsByIdDtoExit;
import com.alura.foroHub.application.exception.topic.TopicByIdNotFoundException;
import com.alura.foroHub.application.mapper.TopicAppMapper;
import com.alura.foroHub.domain.model.Topic;
import com.alura.foroHub.domain.repository.TopicRepository;
import com.alura.foroHub.domain.useCases.topic.SearchTopicById;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
public class SearchTopicByIdImpl implements SearchTopicById {

    private final TopicRepository topicRepository;

    @Override
    public TopicsByIdDtoExit execute(Long idTopic) {

        Topic topic = topicRepository.findById(idTopic)
                .orElseThrow(() -> new TopicByIdNotFoundException(idTopic));

        return TopicAppMapper.topicsByIdDtoExit(topic);
    }
}
