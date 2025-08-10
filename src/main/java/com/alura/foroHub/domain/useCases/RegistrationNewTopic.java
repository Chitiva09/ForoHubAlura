package com.alura.foroHub.domain.useCases;

import com.alura.foroHub.application.dto.CreateTopicDtoExit;
import com.alura.foroHub.application.dto.NewTopicDtoEntrance;

public interface RegistrationNewTopic {

    CreateTopicDtoExit execute (NewTopicDtoEntrance newTopicDtoEntrance);

}
