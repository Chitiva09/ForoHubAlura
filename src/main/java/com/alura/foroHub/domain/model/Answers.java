package com.alura.foroHub.domain.model;

import com.alura.foroHub.infrastructure.entity.TopicEntity;
import com.alura.foroHub.infrastructure.entity.UserEntity;

import java.time.LocalDateTime;

public class Answers {



    private Long id;
    private String message;
    private TopicEntity topicEntity;
    private LocalDateTime creationDate;
    private String author;
    private String solution;
    private UserEntity userEntity;

}
