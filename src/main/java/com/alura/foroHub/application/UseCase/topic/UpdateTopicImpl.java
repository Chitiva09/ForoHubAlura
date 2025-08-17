package com.alura.foroHub.application.UseCase.topic;


import com.alura.foroHub.application.dto.topic.NewTopicDtoEntrance;
import com.alura.foroHub.application.dto.topic.TopicsByIdDtoExit;
import com.alura.foroHub.application.exception.CourseByNameNotFoundException;
import com.alura.foroHub.application.exception.TopicByIdNotFoundException;
import com.alura.foroHub.application.mapper.TopicAppMapper;
import com.alura.foroHub.domain.model.Course;
import com.alura.foroHub.domain.model.Topic;
import com.alura.foroHub.domain.repository.TopicRepository;
import com.alura.foroHub.domain.useCases.course.FindCourseByName;
import com.alura.foroHub.domain.useCases.topic.SearchTopicById;
import com.alura.foroHub.domain.useCases.topic.UpdateTopic;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor
public class UpdateTopicImpl implements UpdateTopic {

    private final SearchTopicById searchTopicById;
    private final TopicRepository topicRepository;
    private final FindCourseByName findCourseByName;

    @Override
    public void execute(Long idTopic) {
        Optional<Topic> existingTopic = Optional.ofNullable(topicRepository.findById(idTopic)
                .orElseThrow(() -> new TopicByIdNotFoundException(idTopic)));
        Optional<Course> optionalCourse = findCourseByName.execute(existingTopic);
        Course course = optionalCourse.orElseThrow(()-> new CourseByNameNotFoundException(topic.cursoName()));
        Topic updateTopic = TopicAppMapper.toModel(newTopicDtoEntrance, course);

        // error aca estoy haciendo la actualizacion mal
        topicRepository.save(updateTopic, course);

    }
}
