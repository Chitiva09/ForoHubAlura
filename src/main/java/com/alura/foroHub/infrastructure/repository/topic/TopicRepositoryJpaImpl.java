package com.alura.foroHub.infrastructure.repository.topic;


import com.alura.foroHub.domain.model.Topic;
import com.alura.foroHub.domain.repository.TopicRepository;
import com.alura.foroHub.infrastructure.entity.TopicEntity;
import com.alura.foroHub.infrastructure.mapper.TopicInfraMapper;

public class TopicRepositoryJpaImpl implements TopicRepository {

    private final TopicRepositoryJpa jpa;

    public TopicRepositoryJpaImpl(TopicRepositoryJpa jpa, TopicInfraMapper topicInfraMapper) {
        this.jpa = jpa;
        this.topicInfraMapper = topicInfraMapper;
    }

    @Override
    public void save(Topic topic) {
        TopicEntity topicEntity = topicInfraMapper.toEntity(topic);
        jpa.save(topicEntity);

    }
}
