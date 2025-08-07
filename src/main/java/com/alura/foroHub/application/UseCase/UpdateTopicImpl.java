package com.alura.foroHub.application.UseCase;


import com.alura.foroHub.application.dto.NewTopicDtoEntrance;
import com.alura.foroHub.application.mapper.TopicAppMapper;
import com.alura.foroHub.domain.model.Topic;
import com.alura.foroHub.domain.repository.TopicRepository;
import com.alura.foroHub.domain.useCases.SearchTopicById;
import com.alura.foroHub.domain.useCases.UpdateTopic;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UpdateTopicImpl implements UpdateTopic {

    private final SearchTopicById searchTopicById;
    private final TopicRepository topicRepository;

    @Override
    public void execute(Long idTopic, NewTopicDtoEntrance newTopicDtoEntrance) {
        searchTopicById.execute(idTopic);

        Topic updateTopic = TopicAppMapper.toModel(newTopicDtoEntrance, idTopic);

        topicRepository.save(updateTopic, idTopic);

    }
}
