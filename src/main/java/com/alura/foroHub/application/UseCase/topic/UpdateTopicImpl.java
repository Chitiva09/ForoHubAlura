package com.alura.foroHub.application.UseCase.topic;


import com.alura.foroHub.application.dto.topic.NewTopicDtoEntrance;
import com.alura.foroHub.application.mapper.TopicAppMapper;
import com.alura.foroHub.domain.model.Topic;
import com.alura.foroHub.domain.repository.TopicRepository;
import com.alura.foroHub.domain.useCases.topic.SearchTopicById;
import com.alura.foroHub.domain.useCases.topic.UpdateTopic;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UpdateTopicImpl implements UpdateTopic {

    private final SearchTopicById searchTopicById;
    private final TopicRepository topicRepository;

    @Override
    public void execute(Long idTopic, NewTopicDtoEntrance newTopicDtoEntrance) {
        searchTopicById.execute(idTopic);

        Topic updateTopic = TopicAppMapper.toModel(newTopicDtoEntrance);

        topicRepository.save(updateTopic, idTopic);

    }
}
