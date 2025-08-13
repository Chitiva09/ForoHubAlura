package com.alura.foroHub.application.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CourseNotFoundException extends RuntimeException {

    public CourseNotFoundException(String nameCourse) {

        super("No se encuentra el curso " + nameCourse + " en la base de datos");
    }

}
