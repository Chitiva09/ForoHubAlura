package com.alura.foroHub.domain.service;


import com.alura.foroHub.application.dto.TopicDto;
import com.alura.foroHub.application.mapper.TopicMapper;
import com.alura.foroHub.domain.model.Topic;
import com.alura.foroHub.domain.repository.TopicRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TopicServiceImpl {

    private final TopicMapper topicMapper;
    private final TopicRepository topicRepository;


    public ResponseEntity<TopicDto> registrationNewTopic(TopicDto topicDto) {


        Topic newTopic = topicMapper.toEntity(topicDto);
        Topic savedTopic = topicRepository.save(newTopic);

        return  topicMapper.toDto(savedTopic);
    }


}
