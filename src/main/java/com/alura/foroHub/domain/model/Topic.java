package com.alura.foroHub.domain.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

public class Topic {

    private Long id;
    private String title;
    private String message;
    private LocalDateTime creationDate;
    private boolean status = true;
    private String author ;
    private Course course;
    private List<Answers> answers;
    private UserModel userModel;

    public Topic(){}

    public Topic(Long id, String title, String message, LocalDateTime creationDate, boolean status, String author, Course course, List<Answers> answers, UserModel userModel) {
        this.id = id;
        this.title = title;
        this.message = message;
        this.creationDate = creationDate;
        this.status = status;
        this.author = author;
        this.course = course;
        this.answers = answers;
        this.userModel = userModel;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public List<Answers> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answers> answers) {
        this.answers = answers;
    }

    public UserModel getUserModel() {
        return userModel;
    }

    public void setUserModel(UserModel userModel) {
        this.userModel = userModel;
    }
}
