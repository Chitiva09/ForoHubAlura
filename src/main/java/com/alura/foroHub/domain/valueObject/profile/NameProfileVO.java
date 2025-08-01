package com.alura.foroHub.domain.valueObject.profile;

import java.util.Objects;

public final class NameProfileVO {

    private final String nameProfile;

    public NameProfileVO(String nameProfile) {
        if (nameProfile == null || nameProfile.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del perfil no puede estar vacío");
        }
        this.nameProfile = nameProfile;
    }

    public String getNameProfile() {
        return nameProfile;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NameProfileVO that = (NameProfileVO) o;
        return Objects.equals(nameProfile, that.nameProfile);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nameProfile);
    }

    @Override
    public String toString() {
        return nameProfile;
    }
}
