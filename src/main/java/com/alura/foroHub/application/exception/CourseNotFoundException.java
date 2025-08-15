package com.alura.foroHub.application.exception;

public class CourseNotFoundException extends RuntimeException {
    public CourseNotFoundException() {
        super("No se encuentran cursos en la base de datos, añade uno nuevo");
    }
}
