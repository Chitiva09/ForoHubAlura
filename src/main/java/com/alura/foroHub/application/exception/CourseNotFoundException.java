package com.alura.foroHub.application.exception;

public class CourseNotFoundException extends RuntimeException {

    public CourseNotFoundException(String nameCourse) {

        super("No se encuentra el curso " + nameCourse + " en la base de datos");
    }

}
