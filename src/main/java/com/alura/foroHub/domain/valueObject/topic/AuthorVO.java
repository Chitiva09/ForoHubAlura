package com.alura.foroHub.domain.valueObject.topic;

import java.util.Objects;

public final class AuthorVO {

    private final String author;

    public AuthorVO(String author) {
        if (author == null || author.trim().isEmpty()) {
            throw new IllegalArgumentException("El autor no puede estar vacío");
        }
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AuthorVO authorVO = (AuthorVO) o;
        return Objects.equals(author, authorVO.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(author);
    }

    @Override
    public String toString() {
        return author;
    }
}
