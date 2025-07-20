package com.alura.foroHub.domain.model;



import java.util.List;

public class UserModel {

    private Long id;
    private String userName;
    private String email;
    private String userPassword;
    private List<Profile> profile;  
    private List<Topic> topic;

    public UserModel(){}
    public UserModel(Long id, String userName, String email, String userPassword, List<Profile> profile, List<Topic> topic) {
        this.id = id;
        this.userName = userName;
        this.email = email;
        this.userPassword = userPassword;
        this.profile = profile;
        this.topic = topic;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public List<Profile> getProfile() {
        return profile;
    }

    public void setProfile(List<Profile> profile) {
        this.profile = profile;
    }

    public List<Topic> getTopic() {
        return topic;
    }

    public void setTopic(List<Topic> topic) {
        this.topic = topic;
    }
}
