package com.alura.foroHub.application.dto.authentication;


public record CreateUserDtoEntrance(

        String userName,
        String email,
        String password

) {
}
