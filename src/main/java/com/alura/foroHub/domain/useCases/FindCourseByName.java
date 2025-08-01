package com.alura.foroHub.domain.useCases;

import com.alura.foroHub.application.dto.NewTopicDtoEntrance;
import com.alura.foroHub.domain.model.Course;

public interface FindCourseByName {
    Long execute (String nameCourse);
}
