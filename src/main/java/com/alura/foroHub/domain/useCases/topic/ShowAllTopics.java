package com.alura.foroHub.domain.useCases.topic;

import com.alura.foroHub.application.dto.topic.ShowAllTopicsDtoExit;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ShowAllTopics {

    Page<ShowAllTopicsDtoExit> execute (Pageable pageable);

}
