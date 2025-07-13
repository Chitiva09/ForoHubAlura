package com.alura.foroHub.application.UseCase;


import com.alura.foroHub.application.dto.NewTopicDtoEntrance;
import com.alura.foroHub.application.mapper.TopicMapper;
import com.alura.foroHub.domain.model.Course;
import com.alura.foroHub.domain.model.Topic;
import com.alura.foroHub.domain.repository.TopicRepository;
import com.alura.foroHub.infrastructure.repository.course.CourseRepositoryJpa;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TopicUseCaseImpl {

    private final TopicMapper topicMapper;
    private final TopicRepository topicRepository;
    private final CourseRepositoryJpa courseRepositoryJpa;

    public void registrationNewTopic(NewTopicDtoEntrance newTopicDtoEntrance) {

        Course courseName = courseRepositoryJpa.findByNameCourse(newTopicDtoEntrance.cursoName())
                .orElseThrow(() -> new RuntimeException("Curso no encontrado"));

        Topic newTopic = topicMapper.toEntity(newTopicDtoEntrance, courseName);

        topicRepository.save(newTopic);
    }


}
