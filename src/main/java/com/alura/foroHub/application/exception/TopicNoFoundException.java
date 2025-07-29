package com.alura.foroHub.application.exception;

public class TopicNoFoundException extends RuntimeException {
    public TopicNoFoundException() {

        super("No se encuentran topics en la base de datos, añade uno nuevo");
    }
}
