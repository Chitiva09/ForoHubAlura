package com.alura.foroHub.domain.useCases.course;

import com.alura.foroHub.application.dto.course.NewCourseDtoEntrance;
import com.alura.foroHub.application.dto.course.NewCourseDtoExit;

public interface RegistrationNewCourse {

    NewCourseDtoExit execute(NewCourseDtoEntrance newCourseDtoEntrance);
}
