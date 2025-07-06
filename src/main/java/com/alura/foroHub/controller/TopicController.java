package com.alura.foroHub.controller;


import com.alura.foroHub.application.dto.TopicDto;
import com.alura.foroHub.application.mapper.TopicMapper;
import com.alura.foroHub.domain.model.Topic;
import com.alura.foroHub.domain.repository.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/topics")
public class TopicController {
    @Autowired
    TopicRepository topicRepository;

    @PostMapping
    public void registrationNewTopic (@RequestBody TopicDto topicDto){

        Topic topic = topicRepository.save(new Topic(topicDto))


    }


}
