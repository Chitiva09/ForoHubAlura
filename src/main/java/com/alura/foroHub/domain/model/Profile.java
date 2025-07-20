package com.alura.foroHub.domain.model;


import java.util.List;

public class Profile {



    private Long id;
    private String nameProfile;
    private List<UserModel> userEntities;

    public Profile(Long id, String nameProfile, List<UserModel> userEntities) {
        this.id = id;
        this.nameProfile = nameProfile;
        this.userEntities = userEntities;
    }

    public Profile() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameProfile() {
        return nameProfile;
    }

    public void setNameProfile(String nameProfile) {
        this.nameProfile = nameProfile;
    }

    public List<UserModel> getUserEntities() {
        return userEntities;
    }

    public void setUserEntities(List<UserModel> userEntities) {
        this.userEntities = userEntities;
    }
}
