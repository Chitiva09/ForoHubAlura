package com.alura.foroHub.domain.useCases.topic;

import com.alura.foroHub.application.dto.topic.ShowAllTopicsDtoExit;

import java.util.List;

public interface ShowAllTopics {

    List<ShowAllTopicsDtoExit> execute ();

}
