package com.alura.foroHub.application.UseCase;

import com.alura.foroHub.application.dto.TopicsByIdDtoExit;
import com.alura.foroHub.application.exception.TopicByIdNotFoundException;
import com.alura.foroHub.application.mapper.TopicAppMapper;
import com.alura.foroHub.domain.model.Topic;
import com.alura.foroHub.domain.repository.TopicRepository;
import com.alura.foroHub.domain.useCases.SearchTopicById;
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
