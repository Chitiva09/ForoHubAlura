package com.alura.foroHub.infrastructure.controller;


import com.alura.foroHub.application.dto.topic.CreateTopicDtoExit;
import com.alura.foroHub.application.dto.topic.NewTopicDtoEntrance;
import com.alura.foroHub.application.dto.topic.ShowAllTopicsDtoExit;
import com.alura.foroHub.application.dto.topic.TopicsByIdDtoExit;
import com.alura.foroHub.domain.useCases.topic.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/topics")
@AllArgsConstructor
public class TopicController {

    private final ShowAllTopics showAllTopics;
    private final RegistrationNewTopic registrationNewTopicUseCase;
    private final SearchTopicById searchTopicById;
    private final UpdateTopic updateTopic;
    private final DeleteTopicById deleteTopic;


    @PostMapping
    public ResponseEntity<CreateTopicDtoExit> registrationNewTopic(@RequestBody @Valid NewTopicDtoEntrance newTopicDtoEntrance, UriComponentsBuilder uriBuilder) {

        CreateTopicDtoExit savedTopic = registrationNewTopicUseCase.execute(newTopicDtoEntrance);

        URI location = uriBuilder // retorna la url para consultar ese topic en específico
                .path("/topics/{id}")
                .buildAndExpand(savedTopic.id())
                .toUri();

        return ResponseEntity.created(location).body(savedTopic);
    }


    @GetMapping
    public ResponseEntity<List<ShowAllTopicsDtoExit>> showAllTopics() {

        List<ShowAllTopicsDtoExit> topicsDtoExits = showAllTopics.execute();

        return ResponseEntity.ok(topicsDtoExits);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<TopicsByIdDtoExit> searchTopicsById(@PathVariable Long idTopic) {

        TopicsByIdDtoExit topicByIdDtoExit = searchTopicById.execute(idTopic);

        return ResponseEntity.ok(topicByIdDtoExit);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> updateTopic(@PathVariable Long idTopic, @RequestBody @Valid NewTopicDtoEntrance newTopicDtoEntrance) {
        updateTopic.execute(idTopic, newTopicDtoEntrance);

        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTopicById(@PathVariable Long id) {

        deleteTopic.execute(id);

        return ResponseEntity.noContent().build();

    }

}
