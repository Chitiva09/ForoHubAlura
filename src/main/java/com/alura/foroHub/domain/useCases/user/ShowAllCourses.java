package com.alura.foroHub.domain.useCases.user;

import com.alura.foroHub.application.dto.course.NewCourseDtoExit;

import java.util.List;

public interface ShowAllCourses {

    List<NewCourseDtoExit> execute();
}
