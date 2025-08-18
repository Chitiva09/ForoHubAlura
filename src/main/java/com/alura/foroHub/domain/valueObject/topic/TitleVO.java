package com.alura.foroHub.domain.valueObject.topic;

import java.util.Objects;

public class TitleVO {

    private final String title;


    public TitleVO(String title) {
        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("El titulo no puede estar vacío");
        }
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    // Comparación por valor
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TitleVO)) return false;
        TitleVO titleVO = (TitleVO) o;
        return title.equals(titleVO.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title);
    }

    // Útil para logs
    @Override
    public String toString() {
        return title;
    }
}


