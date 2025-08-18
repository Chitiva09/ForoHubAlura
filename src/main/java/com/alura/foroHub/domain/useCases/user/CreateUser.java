package com.alura.foroHub.domain.useCases.user;

import com.alura.foroHub.application.dto.authentication.CreateUserDtoEntrance;

public interface CreateUser {

    void execute(CreateUserDtoEntrance createUserDtoEntrance);
}
