package com.alura.foroHub.application.UseCase.topic;


import com.alura.foroHub.application.dto.topic.CreateTopicDtoExit;
import com.alura.foroHub.application.dto.topic.NewTopicDtoEntrance;
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


        Long courseRegistration = findCourseByName.execute(newTopicDtoEntrance.cursoName());

        Topic newTopic = TopicAppMapper.toModel(newTopicDtoEntrance, courseRegistration);


        Topic savedTopic = topicRepository.save(newTopic, courseRegistration);

        return TopicAppMapper.toCreateTopicDtoExit(savedTopic);

    }


}
