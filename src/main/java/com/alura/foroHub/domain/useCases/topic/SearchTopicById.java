package com.alura.foroHub.domain.useCases.topic;

import com.alura.foroHub.application.dto.topic.TopicsByIdDtoExit;

public interface SearchTopicById {

  TopicsByIdDtoExit execute (Long id);

}
