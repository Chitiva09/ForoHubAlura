package com.alura.foroHub.infrastructure.controller;


import com.alura.foroHub.application.dto.topic.CreateTopicDtoExit;
import com.alura.foroHub.application.dto.topic.NewTopicDtoEntrance;
import com.alura.foroHub.application.dto.topic.ShowAllTopicsDtoExit;
import com.alura.foroHub.application.dto.topic.TopicsByIdDtoExit;
import com.alura.foroHub.domain.useCases.topic.*;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/topics")
@SecurityRequirement(name = "bearer-key")
@AllArgsConstructor
public class TopicController {

    private final ShowAllTopics showAllTopics;
    private final RegistrationNewTopic registrationNewTopicUseCase;
    private final SearchTopicById searchTopicById;
    private final UpdateTopic updateTopic;
    private final DeleteTopicById deleteTopic;

    //funciona ok
    @PostMapping
    public ResponseEntity<CreateTopicDtoExit> registrationNewTopic(@RequestBody @Valid NewTopicDtoEntrance newTopicDtoEntrance, UriComponentsBuilder uriBuilder) {
        CreateTopicDtoExit savedTopic = registrationNewTopicUseCase.execute(newTopicDtoEntrance);
        URI location = uriBuilder // retorna la url para consultar ese topic en específico
                .path("/topics/{id}")
                .buildAndExpand(savedTopic.id())
                .toUri();
        return ResponseEntity.created(location).body(savedTopic);
    }

    //funciona ok
    @GetMapping
    public ResponseEntity<Page<ShowAllTopicsDtoExit>> showAllTopics(@PageableDefault(size = 5, sort = {"creationDate"}) Pageable pageable) {

        Page<ShowAllTopicsDtoExit> topicsDtoExits = (showAllTopics.execute(pageable));

        return ResponseEntity.ok(topicsDtoExits);
    }

    //funciona ok
    @GetMapping(value = "/{id}")
    public ResponseEntity<TopicsByIdDtoExit> searchTopicsById(@PathVariable Long id) {

        TopicsByIdDtoExit topicByIdDtoExit = searchTopicById.execute(id);

        return ResponseEntity.ok(topicByIdDtoExit);
    }

    //funciona ok
    @PutMapping(value = "/{id}")
    public ResponseEntity<?> updateTopic(@PathVariable Long id, @RequestBody @Valid NewTopicDtoEntrance newTopicDtoEntrance) {
        updateTopic.execute(id, newTopicDtoEntrance);

        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

    //funciona ok
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTopicById(@PathVariable Long id) {

        deleteTopic.execute(id);

        return ResponseEntity.noContent().build();

    }

}
