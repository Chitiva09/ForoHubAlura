package com.alura.foroHub.domain.useCases.user;

import com.alura.foroHub.application.dto.course.NewCourseDtoExit;
import com.alura.foroHub.domain.model.Course;

import java.util.List;

public interface ShowAllCourses {

    List<NewCourseDtoExit> execute ();
}
