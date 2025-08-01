package com.alura.foroHub.domain.valueObject.answer;

import java.util.Objects;

public final class MessageAnswerVO {

    private final String messageAnswer;

    public MessageAnswerVO(String messageAnswer) {
        if (messageAnswer == null || messageAnswer.trim().isEmpty()) {
            throw new IllegalArgumentException("El mensaje de respuesta no puede estar vacío");
        }
        this.messageAnswer = messageAnswer;
    }

    public String getMessageAnswer() {
        return messageAnswer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MessageAnswerVO that = (MessageAnswerVO) o;
        return Objects.equals(messageAnswer, that.messageAnswer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(messageAnswer);
    }

    @Override
    public String toString() {
        return messageAnswer;
    }
}
