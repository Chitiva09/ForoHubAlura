package com.alura.foroHub.application.exception.topic;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class TopicNotFoundException extends RuntimeException {
    public TopicNotFoundException() {
        super("No se encuentran topics en la base de datos, añade uno nuevo");
    }
}
