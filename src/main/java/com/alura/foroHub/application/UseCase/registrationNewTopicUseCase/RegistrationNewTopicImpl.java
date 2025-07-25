package com.alura.foroHub.application.UseCase.registrationNewTopicUseCase;


import com.alura.foroHub.application.dto.NewTopicDtoEntrance;
import com.alura.foroHub.application.mapper.TopicMapper;
import com.alura.foroHub.domain.model.Topic;

import com.alura.foroHub.domain.repository.TopicRepository;
import com.alura.foroHub.domain.useCases.FindCourseByName;
import com.alura.foroHub.domain.useCases.RegistrationNewTopic;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class RegistrationNewTopicImpl implements RegistrationNewTopic {

    private final TopicMapper topicMapper;
    private final TopicRepository topicRepository;

    private final FindCourseByName findCourseByName;
    @Override
    public void registrationNewTopic(NewTopicDtoEntrance newTopicDtoEntrance) {


        Long courseRegistrationId = findCourseByName.execute(newTopicDtoEntrance.cursoName());

        Topic newTopic = topicMapper.toModel(newTopicDtoEntrance, courseRegistrationId);

        topicRepository.save(newTopic, courseRegistrationId);

    }


}
