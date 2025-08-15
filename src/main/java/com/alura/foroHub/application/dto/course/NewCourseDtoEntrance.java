package com.alura.foroHub.application.dto.course;

import jakarta.validation.constraints.NotBlank;

public record NewCourseDtoEntrance(

        @NotBlank(message = "Debes ingresar un nombre del curso")
        String nameCourse,
        @NotBlank(message = "Has ingresado una categoria inexistente")
        String category

) {
}
