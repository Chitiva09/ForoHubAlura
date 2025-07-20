package com.alura.foroHub.application.UseCase.registrationNewTopicUseCase;


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

    @Override
    public void registrationNewTopic(NewTopicDtoEntrance newTopicDtoEntrance) {

        Course courseRegistrationName = courseRepository.findByNameCourse(newTopicDtoEntrance.cursoName())
                .orElseThrow(() -> new RuntimeException("Curso no encontrado"));

        Topic newTopic = topicMapper.toModel(newTopicDtoEntrance, courseRegistrationName);

        topicRepository.save(newTopic, courseRegistrationName);

    }


}
