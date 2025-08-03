package com.alura.foroHub.domain.useCases;

import com.alura.foroHub.application.dto.TopicsByIdDtoExit;

public interface SearchTopicById {

    public TopicsByIdDtoExit execute (Long id);

}
