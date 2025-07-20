package com.alura.foroHub.infrastructure.controller;


import com.alura.foroHub.application.UseCase.registrationNewTopicUseCase.RegistrationNewTopic;
import com.alura.foroHub.application.dto.NewTopicDtoEntrance;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/topics")
@AllArgsConstructor
public class TopicController {


    private final RegistrationNewTopic topicUseCase;

    @PostMapping
    public ResponseEntity<Void> registrationNewTopic (@RequestBody @Valid NewTopicDtoEntrance newTopicDtoEntrance){

        topicUseCase.registrationNewTopic(newTopicDtoEntrance);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }


}
