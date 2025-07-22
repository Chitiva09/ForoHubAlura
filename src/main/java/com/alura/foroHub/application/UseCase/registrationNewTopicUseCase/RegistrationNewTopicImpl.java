package com.alura.foroHub.application.UseCase.registrationNewTopicUseCase;


import com.alura.foroHub.application.UseCase.findCourseByNameUseCase.FindCourseByName;
import org.springframework.stereotype.Service;

import com.alura.foroHub.application.dto.NewTopicDtoEntrance;
import com.alura.foroHub.application.mapper.TopicMapper;
import com.alura.foroHub.domain.model.Course;
import com.alura.foroHub.domain.model.Topic;
import com.alura.foroHub.domain.repository.CourseRepository;
import com.alura.foroHub.domain.repository.TopicRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RegistrationNewTopicImpl implements RegistrationNewTopic{

    private final TopicMapper topicMapper;
    private final TopicRepository topicRepository;
    private final CourseRepository courseRepository;
    private final FindCourseByName findCourseByName;
    @Override
    public void registrationNewTopic(NewTopicDtoEntrance newTopicDtoEntrance) {


        String courseRegistrationId = findCourseByName.findCourseByName(newTopicDtoEntrance.cursoName());

        Topic newTopic = topicMapper.toModel(newTopicDtoEntrance, courseRegistrationId);

        topicRepository.save(newTopic, courseRegistrationId);

    }


}
