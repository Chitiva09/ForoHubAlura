package com.alura.foroHub.domain.valueObject.topic;

import java.util.Objects;

import java.util.Objects;

public final class MessageVO {

    private final String message;

    public MessageVO(String message) {
        if (message == null || message.trim().isEmpty()) {
            throw new IllegalArgumentException("El mensaje no puede estar vacío");
        }
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MessageVO messageVO = (MessageVO) o;
        return Objects.equals(message, messageVO.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(message);
    }

    @Override
    public String toString() {
        return message;
    }
}
