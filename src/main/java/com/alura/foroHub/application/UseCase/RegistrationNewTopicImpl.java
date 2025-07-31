package com.alura.foroHub.application.UseCase;


import com.alura.foroHub.application.dto.NewTopicDtoEntrance;
import com.alura.foroHub.application.mapper.TopicAppMapper;
import com.alura.foroHub.domain.model.Topic;

import com.alura.foroHub.domain.repository.TopicRepository;
import com.alura.foroHub.domain.useCases.FindCourseByName;
import com.alura.foroHub.domain.useCases.RegistrationNewTopic;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class RegistrationNewTopicImpl implements RegistrationNewTopic {

    private final TopicAppMapper topicAppMapper;
    private final TopicRepository topicRepository;
    private final FindCourseByName findCourseByName;

    @Override
    public void execute(NewTopicDtoEntrance newTopicDtoEntrance) {


        Long courseRegistrationId = findCourseByName.execute(newTopicDtoEntrance.cursoName());

        Topic newTopic = topicAppMapper.toModel(newTopicDtoEntrance, courseRegistrationId);

        topicRepository.save(newTopic, courseRegistrationId);

    }


}
