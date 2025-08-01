package com.alura.foroHub.infrastructure.controller;


import com.alura.foroHub.application.dto.NewTopicDtoEntrance;
import com.alura.foroHub.application.dto.ShowAllTopicsDtoExit;
import com.alura.foroHub.domain.useCases.RegistrationNewTopic;
import com.alura.foroHub.domain.useCases.ShowAllTopics;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/topics")
@AllArgsConstructor
public class TopicController {

    private final ShowAllTopics showAllTopics;
    private final RegistrationNewTopic RegistrationNewTopicUseCase;

    @PostMapping
    public ResponseEntity<Void> registrationNewTopic (@RequestBody @Valid NewTopicDtoEntrance newTopicDtoEntrance){

        RegistrationNewTopicUseCase.execute(newTopicDtoEntrance);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }


    @GetMapping
    public ResponseEntity<List<ShowAllTopicsDtoExit>> showAllTopics (){

        List<ShowAllTopicsDtoExit> topicsDtoExits = showAllTopics.execute();

        return ResponseEntity.ok(topicsDtoExits);
    }

}
