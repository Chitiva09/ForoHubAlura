package com.alura.foroHub.application.exception;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String message) {

        super("No se encuentra el curso " + message + " en la base de datos");
    }
}
