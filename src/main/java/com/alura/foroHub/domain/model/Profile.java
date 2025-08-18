package com.alura.foroHub.domain.model;

import com.alura.foroHub.domain.valueObject.profile.NameProfileVO;

import java.util.ArrayList;
import java.util.List;

public class Profile {

    private Long id;
    private NameProfileVO nameProfile;
    private List<UserModel> userEntities;

    public Profile(Long id, NameProfileVO nameProfile, List<UserModel> userEntities) {
        this.id = id;
        this.nameProfile = nameProfile;
        this.userEntities = userEntities;
    }

    public Profile() {
    }

    // Constructor privado para el Builder
    private Profile(ProfileBuilder builder) {
        this.id = builder.id;
        this.nameProfile = builder.nameProfile;
        this.userEntities = builder.userEntities;
    }

    // Método estático para crear el Builder
    public static ProfileBuilder builder() {
        return new ProfileBuilder();
    }

    // Clase Builder interna
    public static class ProfileBuilder {
        private Long id;
        private NameProfileVO nameProfile;
        private List<UserModel> userEntities = new ArrayList<>();

        public ProfileBuilder withId(Long id) {
            this.id = id;
            return this;
        }

        public ProfileBuilder withNameProfile(NameProfileVO nameProfile) {
            this.nameProfile = nameProfile;
            return this;
        }

        public ProfileBuilder withUserEntities(List<UserModel> userEntities) {
            this.userEntities = userEntities != null ? new ArrayList<>(userEntities) : new ArrayList<>();
            return this;
        }

        public ProfileBuilder addUserEntity(UserModel userEntity) {
            if (this.userEntities == null) {
                this.userEntities = new ArrayList<>();
            }
            this.userEntities.add(userEntity);
            return this;
        }

        public Profile build() {
            return new Profile(this);
        }
    }

    public Long getId() {
        return id;
    }

    public NameProfileVO getNameProfile() {
        return nameProfile;
    }

    public List<UserModel> getUserEntities() {
        return userEntities;
    }
}
