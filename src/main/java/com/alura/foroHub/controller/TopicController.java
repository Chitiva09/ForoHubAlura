package com.alura.foroHub.controller;


import com.alura.foroHub.application.dto.TopicDto;

import com.alura.foroHub.domain.repository.TopicRepository;
import com.alura.foroHub.domain.service.TopicService;
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
    TopicRepository topicRepository;

    @Autowired
    TopicService topicService;

    @PostMapping
    public ResponseEntity<TopicDto> registrationNewTopic (@RequestBody TopicDto topicDto){

        TopicDto topic = topicService.registrationNewTopic(topicDto);

        return new ResponseEntity<>(HttpStatus.OK);
    }


}
