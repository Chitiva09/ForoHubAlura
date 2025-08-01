package com.alura.foroHub.domain.valueObject.userModelVO;

import java.util.Objects;

public final class EmailVO {
    private final String email;

    public EmailVO(String email) {
        if (email == null || email.trim().isEmpty()) {
            throw new IllegalArgumentException("El email no puede estar vacío");
        }
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmailVO emailVO = (EmailVO) o;
        return Objects.equals(email, emailVO.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email);
    }

    @Override
    public String toString() {
        return email;
    }
}
