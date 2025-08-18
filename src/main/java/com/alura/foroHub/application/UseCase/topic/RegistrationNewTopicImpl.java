package com.alura.foroHub.application.UseCase.topic;


import com.alura.foroHub.application.dto.topic.CreateTopicDtoExit;
import com.alura.foroHub.application.dto.topic.NewTopicDtoEntrance;
import com.alura.foroHub.application.exception.course.CourseByNameNotFoundException;
import com.alura.foroHub.application.mapper.TopicAppMapper;

import com.alura.foroHub.domain.model.Course;
import com.alura.foroHub.domain.model.Topic;

import com.alura.foroHub.domain.repository.TopicRepository;
import com.alura.foroHub.domain.useCases.course.FindCourseByName;
import com.alura.foroHub.domain.useCases.topic.RegistrationNewTopic;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor
public class RegistrationNewTopicImpl implements RegistrationNewTopic {

    private final TopicRepository topicRepository;
    private final FindCourseByName findCourseByName;

    @Override
    public CreateTopicDtoExit execute(NewTopicDtoEntrance newTopicDtoEntrance) {

        //validar que el curso que viene en el dto exista, si no existe dar error porque no existe ese curso
        Optional<Course> courseDomain = findCourseByName.execute(newTopicDtoEntrance.cursoName());
        Course course = courseDomain.orElseThrow(()-> new CourseByNameNotFoundException(newTopicDtoEntrance.cursoName()));
        Topic newTopic = TopicAppMapper.toModel(newTopicDtoEntrance, course);


        Topic savedTopic = topicRepository.save(newTopic, course);

        return TopicAppMapper.toCreateTopicDtoExit(savedTopic);

    }


}
