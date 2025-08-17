package com.alura.foroHub.domain.valueObject.course;



import com.alura.foroHub.domain.model.Course;

import java.util.Objects;


public final class NameCourseVO {

    private final String nameCourse;

    public NameCourseVO(String nameCourse) {
        if (nameCourse == null || nameCourse.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del curso no puede estar vacío");
        }
        this.nameCourse = nameCourse;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NameCourseVO that = (NameCourseVO) o;
        return Objects.equals(nameCourse, that.nameCourse);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nameCourse);
    }

    @Override
    public String toString() {
        return nameCourse;
    }

    public String getNameCourse() {
        return nameCourse;
    }

}
