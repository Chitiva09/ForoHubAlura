package com.alura.foroHub.domain.useCases.topic;

import com.alura.foroHub.application.dto.topic.CreateTopicDtoExit;
import com.alura.foroHub.application.dto.topic.NewTopicDtoEntrance;

public interface RegistrationNewTopic {

    CreateTopicDtoExit execute(NewTopicDtoEntrance newTopicDtoEntrance);

}
