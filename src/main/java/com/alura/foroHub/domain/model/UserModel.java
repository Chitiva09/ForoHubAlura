package com.alura.foroHub.domain.model;



import java.util.List;

public class UserModel {

    private Long id;
    private String userName;
    private String email;
    private String userPassword;
    private List<Profile> profile;  
    private List<Topic> topic;

}
