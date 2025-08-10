package com.alura.foroHub.infrastructure.persistence.user;

import com.alura.foroHub.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
public class UserRepositoryJpaAdapter implements UserRepository {

    private final UserRepositoryJpa jpa;

//https://app.aluracursos.com/course/spring-boot-3-aplique-mejores-practicas-proteja-api-rest/task/91598


}
