package com.alura.foroHub.application.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class TopicByIdNotFoundException extends RuntimeException {
    public TopicByIdNotFoundException(Long id) {
        super("No se encontró un topic con el ID: " + id);
    }
}
