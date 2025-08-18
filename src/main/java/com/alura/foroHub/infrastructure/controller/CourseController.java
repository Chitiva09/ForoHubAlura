package com.alura.foroHub.infrastructure.controller;

import com.alura.foroHub.application.dto.course.NewCourseDtoEntrance;
import com.alura.foroHub.application.dto.course.NewCourseDtoExit;
import com.alura.foroHub.domain.useCases.course.RegistrationNewCourse;
import com.alura.foroHub.domain.useCases.user.ShowAllCourses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("course")
@SecurityRequirement(name = "bearer-key")
@RequiredArgsConstructor
public class CourseController {

    private final RegistrationNewCourse registrationNewCourse;
    private final ShowAllCourses showAllCourses;

    @PostMapping
    public ResponseEntity<NewCourseDtoExit> createCourse(@RequestBody @Valid NewCourseDtoEntrance newCourseDtoEntrance, UriComponentsBuilder uriBuilder) {

        NewCourseDtoExit savedCourse = registrationNewCourse.execute(newCourseDtoEntrance);

        URI location = uriBuilder // retorna la url para consultar ese curso en específico
                .path("/topics/{id}")
                .buildAndExpand(savedCourse.id())
                .toUri();

        return ResponseEntity.created(location).body(savedCourse);

    }

    @GetMapping
    public ResponseEntity<List<NewCourseDtoExit>> showAllCourses() {

        List<NewCourseDtoExit> courses = showAllCourses.execute();

        return ResponseEntity.ok(courses);

    }


}
