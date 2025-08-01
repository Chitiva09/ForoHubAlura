package com.alura.foroHub.domain.valueObject.userModelVO;

import java.util.Objects;

public final class UserPasswordVO {
    private final String userPassword;

    public UserPasswordVO(String userPassword) {
        if (userPassword == null || userPassword.trim().isEmpty()) {
            throw new IllegalArgumentException("La contraseña no puede estar vacía");
        }
        this.userPassword = userPassword;
    }

    public String getUserPassword() {
        return userPassword;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserPasswordVO that = (UserPasswordVO) o;
        return Objects.equals(userPassword, that.userPassword);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userPassword);
    }

    @Override
    public String toString() {
        return userPassword;
    }
}
