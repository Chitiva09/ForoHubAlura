package com.alura.foroHub.domain.valueObject.topic;

import java.time.LocalDateTime;

public class CreationDateVO {

    private final LocalDateTime creationDate;

    public CreationDateVO(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }
}
