package com.alura.foroHub.domain.useCases;

import com.alura.foroHub.application.dto.NewTopicDtoEntrance;

public interface UpdateTopic {
    void execute(Long idTopic,NewTopicDtoEntrance newTopicDtoEntrance);
}
