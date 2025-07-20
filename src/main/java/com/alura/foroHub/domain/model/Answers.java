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
    private UserModel userEntity;

    public Answers (){}
    public Answers(Long id, String message, TopicEntity topicEntity, LocalDateTime creationDate, String author, String solution, UserModel userEntity) {
        this.id = id;
        this.message = message;
        this.topicEntity = topicEntity;
        this.creationDate = creationDate;
        this.author = author;
        this.solution = solution;
        this.userEntity = userEntity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public TopicEntity getTopicEntity() {
        return topicEntity;
    }

    public void setTopicEntity(TopicEntity topicEntity) {
        this.topicEntity = topicEntity;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getSolution() {
        return solution;
    }

    public void setSolution(String solution) {
        this.solution = solution;
    }

    public UserModel getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserModel userEntity) {
        this.userEntity = userEntity;
    }
}
