package com.alura.foroHub.domain.model;

import com.alura.foroHub.infrastructure.entity.ProfileEntity;
import com.alura.foroHub.infrastructure.entity.TopicEntity;
import jakarta.persistence.*;

import java.util.List;

public class UserModel {

    private Long id;
    private String userName;
    private String email;
    private String userPassword;
    private List<ProfileEntity> profileEntities;
    private List<TopicEntity> topicEntities;

}
