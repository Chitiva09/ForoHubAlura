package com.alura.foroHub.application.exception;

public class TopicByIdNotFoundException extends RuntimeException {
    public TopicByIdNotFoundException(Long id) {
        super("No se encontró un topic con el ID: " + id);
    }
}
