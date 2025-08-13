package com.alura.foroHub.application.UseCase.topic;

import com.alura.foroHub.domain.repository.TopicRepository;
import com.alura.foroHub.domain.useCases.topic.DeleteTopicById;
import com.alura.foroHub.domain.useCases.topic.SearchTopicById;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DeleteTopicByIdImpl implements DeleteTopicById {

    private final SearchTopicById searchTopicById;
    private final TopicRepository topicRepository;

    @Override
    public void execute (Long id){

        searchTopicById.execute(id);

        topicRepository.deleteById(id);

    }


}
