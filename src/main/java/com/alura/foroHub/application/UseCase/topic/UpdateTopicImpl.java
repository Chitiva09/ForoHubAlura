package com.alura.foroHub.application.UseCase.topic;

import com.alura.foroHub.application.dto.topic.NewTopicDtoEntrance;
import com.alura.foroHub.application.exception.course.CourseByNameNotFoundException;
import com.alura.foroHub.application.exception.topic.TopicByIdNotFoundException;
import com.alura.foroHub.application.mapper.TopicAppMapper;
import com.alura.foroHub.domain.model.Course;
import com.alura.foroHub.domain.model.Topic;
import com.alura.foroHub.domain.repository.TopicRepository;
import com.alura.foroHub.domain.useCases.course.FindCourseByName;
import com.alura.foroHub.domain.useCases.topic.SearchTopicById;
import com.alura.foroHub.domain.useCases.topic.UpdateTopic;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UpdateTopicImpl implements UpdateTopic {

    private final SearchTopicById searchTopicById;
    private final TopicRepository topicRepository;
    private final FindCourseByName findCourseByName;

    @Override
    public void execute(Long idTopic, NewTopicDtoEntrance newTopicDtoEntrance) {
        Topic existingTopic = topicRepository.findById(idTopic)
                .orElseThrow(() -> new TopicByIdNotFoundException(idTopic));

        Course course = findCourseByName.execute(newTopicDtoEntrance.cursoName())
                .orElseThrow(()-> new CourseByNameNotFoundException(newTopicDtoEntrance.cursoName()));

        Topic updateTopic = TopicAppMapper.toUpdateModel(existingTopic, newTopicDtoEntrance, course);

        topicRepository.save(updateTopic,course);
    }
}
