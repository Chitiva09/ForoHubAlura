package com.alura.foroHub.domain.useCases.topic;

import com.alura.foroHub.application.dto.topic.NewTopicDtoEntrance;

public interface UpdateTopic {
    void execute(Long idTopic, NewTopicDtoEntrance newTopicDtoEntrance);
}
