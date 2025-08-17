package com.alura.foroHub.domain.valueObject.answer;

import java.util.Objects;

public final class AuthorAnswerVO {

    private final String authorAnswer;

    public AuthorAnswerVO(String authorAnswer) {
        if (authorAnswer == null || authorAnswer.trim().isEmpty()) {
            throw new IllegalArgumentException("El autor de la respuesta no puede estar vacío");
        }
        this.authorAnswer = authorAnswer;
    }

    public String getAuthorAnswer() {
        return authorAnswer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AuthorAnswerVO that = (AuthorAnswerVO) o;
        return Objects.equals(authorAnswer, that.authorAnswer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(authorAnswer);
    }

    @Override
    public String toString() {
        return authorAnswer;
    }


}
