package com.alura.foroHub.domain.useCases;

import com.alura.foroHub.application.dto.ShowAllTopicsDtoExit;

import java.util.List;

public interface ShowAllTopics {

    List<ShowAllTopicsDtoExit> showAllTopics ();

}
