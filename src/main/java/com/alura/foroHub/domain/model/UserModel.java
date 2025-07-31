package com.alura.foroHub.domain.model;

import com.alura.foroHub.domain.valueObject.userModelVO.EmailVO;
import com.alura.foroHub.domain.valueObject.userModelVO.UserNameVO;
import com.alura.foroHub.domain.valueObject.userModelVO.UserPasswordVO;

import java.util.ArrayList;
import java.util.List;

public class UserModel {

    private Long id;
    private UserNameVO userName;
    private EmailVO email;
    private UserPasswordVO userPassword;
    private List<Profile> profile;  
    private List<Topic> topic;

    public UserModel(){}
    
    public UserModel(Long id, UserNameVO userName, EmailVO email, UserPasswordVO userPassword, List<Profile> profile, List<Topic> topic) {
        this.id = id;
        this.userName = userName;
        this.email = email;
        this.userPassword = userPassword;
        this.profile = profile;
        this.topic = topic;
    }

    // Constructor privado para el Builder
    private UserModel(UserModelBuilder builder) {
        this.id = builder.id;
        this.userName = builder.userName;
        this.email = builder.email;
        this.userPassword = builder.userPassword;
        this.profile = builder.profile;
        this.topic = builder.topic;
    }

    // Método estático para crear el Builder
    public static UserModelBuilder builder() {
        return new UserModelBuilder();
    }

    // Clase Builder interna
    public static class UserModelBuilder {
        private Long id;
        private UserNameVO userName;
        private EmailVO email;
        private UserPasswordVO userPassword;
        private List<Profile> profile = new ArrayList<>();
        private List<Topic> topic = new ArrayList<>();

        public UserModelBuilder withId(Long id) {
            this.id = id;
            return this;
        }

        public UserModelBuilder withUserName(UserNameVO userName) {
            this.userName = userName;
            return this;
        }

        public UserModelBuilder withEmail(EmailVO email) {
            this.email = email;
            return this;
        }

        public UserModelBuilder withUserPassword(UserPasswordVO userPassword) {
            this.userPassword = userPassword;
            return this;
        }

        public UserModelBuilder withProfile(List<Profile> profile) {
            this.profile = profile != null ? new ArrayList<>(profile) : new ArrayList<>();
            return this;
        }

        public UserModelBuilder addProfile(Profile profile) {
            if (this.profile == null) {
                this.profile = new ArrayList<>();
            }
            this.profile.add(profile);
            return this;
        }

        public UserModelBuilder withTopic(List<Topic> topic) {
            this.topic = topic != null ? new ArrayList<>(topic) : new ArrayList<>();
            return this;
        }

        public UserModelBuilder addTopic(Topic topic) {
            if (this.topic == null) {
                this.topic = new ArrayList<>();
            }
            this.topic.add(topic);
            return this;
        }

        public UserModel build() {
            return new UserModel(this);
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserNameVO getUserName() {
        return userName;
    }

    public void setUserName(UserNameVO userName) {
        this.userName = userName;
    }

    public EmailVO getEmail() {
        return email;
    }

    public void setEmail(EmailVO email) {
        this.email = email;
    }

    public UserPasswordVO getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(UserPasswordVO userPassword) {
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
