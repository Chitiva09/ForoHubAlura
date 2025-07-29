package com.alura.foroHub.application.UseCase;

import com.alura.foroHub.application.dto.ShowAllTopicsDtoExit;
import com.alura.foroHub.application.exception.CourseNotFoundException;
import com.alura.foroHub.application.exception.TopicNoFoundException;
import com.alura.foroHub.application.mapper.ShowAllTopicAppMapper;
import com.alura.foroHub.domain.model.Topic;
import com.alura.foroHub.domain.repository.TopicRepository;
import com.alura.foroHub.domain.useCases.ShowAllTopics;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class ShowAllTopicsImpl implements ShowAllTopics {

    private final TopicRepository topicRepository;
    private final ShowAllTopicAppMapper showAllTopicAppMapper;

    @Override
    public List<ShowAllTopicsDtoExit> showAllTopics (){

        List<Topic> topics = topicRepository.findAll();
        if (topics.isEmpty()){
            throw new TopicNoFoundException();

        }


        return topics.stream()
                .map(topic -> showAllTopicAppMapper.toDto());

    }

}
