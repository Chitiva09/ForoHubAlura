package com.alura.foroHub.domain.valueObject.userModelVO;

import java.util.Objects;

public final class UserNameVO {
    private final String userName;

    public UserNameVO(String userName) {
        if (userName == null || userName.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre de usuario no puede estar vacío");
        }
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserNameVO that = (UserNameVO) o;
        return Objects.equals(userName, that.userName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userName);
    }

    @Override
    public String toString() {
        return userName;
    }
}
