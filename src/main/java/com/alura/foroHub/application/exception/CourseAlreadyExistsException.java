package com.alura.foroHub.application.exception;

public class CourseAlreadyExistsException extends RuntimeException {
    public CourseAlreadyExistsException(String nameCourse) {

        super("El curso con nombre '" + nameCourse + "' ya existe en la base de datos");
    }
}
