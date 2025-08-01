package com.alura.foroHub.domain.valueObject.answer;

import java.util.Objects;

public final class SolutionVO {

    private final String solution;

    public SolutionVO(String solution) {
        if (solution == null || solution.trim().isEmpty()) {
            throw new IllegalArgumentException("La solución no puede estar vacía");
        }
        this.solution = solution;
    }

    public String getSolution() {
        return solution;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SolutionVO that = (SolutionVO) o;
        return Objects.equals(solution, that.solution);
    }

    @Override
    public int hashCode() {
        return Objects.hash(solution);
    }

    @Override
    public String toString() {
        return solution;
    }
}
