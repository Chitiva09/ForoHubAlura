package com.alura.foroHub.application.exception;

public class TopicNotFoundException extends RuntimeException {
    public TopicNotFoundException() {

        super("No se encuentran topics en la base de datos, añade uno nuevo");
    }
}
