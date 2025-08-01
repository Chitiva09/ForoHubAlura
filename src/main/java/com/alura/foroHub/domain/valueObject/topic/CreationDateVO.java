package com.alura.foroHub.domain.valueObject.topic;

import java.time.LocalDateTime;

import java.util.Objects;

public final class CreationDateVO {

    private final LocalDateTime creationDate;

    public CreationDateVO(LocalDateTime creationDate) {
        if (creationDate == null) {
            throw new IllegalArgumentException("La fecha de creación no puede ser nula");
        }
        this.creationDate = creationDate;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CreationDateVO that = (CreationDateVO) o;
        return Objects.equals(creationDate, that.creationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(creationDate);
    }

    @Override
    public String toString() {
        return creationDate.toString();
    }
}
