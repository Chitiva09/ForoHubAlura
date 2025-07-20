package com.alura.foroHub.domain.model;


import java.util.List;

public class Course {


    private Long id;
    private String nameCourse;
    private String category;

    private List<Topic> topic;

    public Course(Long id, String nameCourse, String category) {
        this.id = id;
        this.nameCourse = nameCourse;
        this.category = category;

    }

    public Course() {
    }

    public String getNameCourse() {
        return nameCourse;
    }

    public String getCategory() {
        return category;
    }

    public List<Topic> getTopic() {
        return topic;
    }

    public Long getId() {
        return id;
    }

    public void setTopic(List<Topic> topic) {
        this.topic = topic;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setNameCourse(String nameCourse) {
        this.nameCourse = nameCourse;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
