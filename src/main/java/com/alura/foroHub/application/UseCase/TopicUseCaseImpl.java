package com.alura.foroHub.application.UseCase;


import com.alura.foroHub.application.dto.NewTopicDtoEntrance;
import com.alura.foroHub.application.mapper.TopicMapper;
import com.alura.foroHub.infrastructure.entity.CourseEntity;
import com.alura.foroHub.infrastructure.entity.TopicEntity;
import com.alura.foroHub.domain.repository.CourseRepository;
import com.alura.foroHub.domain.repository.TopicRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TopicUseCaseImpl implements TopicUseCase{

    private final TopicMapper topicMapper;
    private final TopicRepository topicRepository;
    private final CourseRepository courseRepository;

    public NewTopicDtoEntrance registrationNewTopic(NewTopicDtoEntrance newTopicDtoEntrance) {

        CourseEntity courseEntityName = courseRepository.findByNameCourse(newTopicDtoEntrance.cursoName())
                .orElseThrow(() -> new RuntimeException("Curso no encontrado"));

        TopicEntity newTopicEntity = topicMapper.toEntity(newTopicDtoEntrance, courseEntityName);

        topicRepository.save(newTopicEntity);
        return newTopicDtoEntrance;
    }


}
