package com.alura.foroHub.application.UseCase.topic;


import com.alura.foroHub.application.dto.topic.CreateTopicDtoExit;
import com.alura.foroHub.application.dto.topic.NewTopicDtoEntrance;
import com.alura.foroHub.application.exception.CourseByNameNotFoundException;
import com.alura.foroHub.application.mapper.TopicAppMapper;

import com.alura.foroHub.domain.model.Topic;

import com.alura.foroHub.domain.repository.TopicRepository;
import com.alura.foroHub.domain.useCases.course.FindCourseByName;
import com.alura.foroHub.domain.useCases.topic.RegistrationNewTopic;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class RegistrationNewTopicImpl implements RegistrationNewTopic {

    private final TopicRepository topicRepository;
    private final FindCourseByName findCourseByName;

    @Override
    public CreateTopicDtoExit execute(NewTopicDtoEntrance newTopicDtoEntrance) {

        //validar que el curso que viene en el dto exista, si no existe dar error porque no existe ese curso
        Long courseRegistration = findCourseByName.execute(newTopicDtoEntrance.cursoName());
        if (courseRegistration ==  null){
            throw new CourseByNameNotFoundException(newTopicDtoEntrance.cursoName());
        }


        Topic newTopic = TopicAppMapper.toModel(newTopicDtoEntrance);


        Topic savedTopic = topicRepository.save(newTopic, courseRegistration);

        return TopicAppMapper.toCreateTopicDtoExit(savedTopic);

    }


}
