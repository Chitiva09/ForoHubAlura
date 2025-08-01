package com.alura.foroHub.domain.valueObject.answer;

import java.util.Objects;

public final class CreationDateAnswerVO {

    private final String creationDate;

    public CreationDateAnswerVO(String creationDate) {
        if (creationDate == null || creationDate.trim().isEmpty()) {
            throw new IllegalArgumentException("La fecha de creación no puede estar vacía");
        }
        this.creationDate = creationDate;
    }

    public String getCreationDate() {
        return creationDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CreationDateAnswerVO that = (CreationDateAnswerVO) o;
        return Objects.equals(creationDate, that.creationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(creationDate);
    }

    @Override
    public String toString() {
        return creationDate;
    }
}
