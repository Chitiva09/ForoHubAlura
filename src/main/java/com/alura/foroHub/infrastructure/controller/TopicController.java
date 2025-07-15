package com.alura.foroHub.infrastructure.controller;


import com.alura.foroHub.application.dto.NewTopicDtoEntrance;

import com.alura.foroHub.application.UseCase.TopicUseCase;
import com.alura.foroHub.domain.repository.TopicRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/topics")
public class TopicController {
    @Autowired
    TopicRepository topicRepositoryJpa;

    @Autowired
    TopicUseCase topicUseCase;

    @PostMapping
    public ResponseEntity registrationNewTopic (@RequestBody @Valid NewTopicDtoEntrance newTopicDtoEntrance){

        topicUseCase.registrationNewTopic(newTopicDtoEntrance);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }


}
