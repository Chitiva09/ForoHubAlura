package com.alura.foroHub.infrastructure.repository.topic;

import com.alura.foroHub.infrastructure.entity.TopicEntity;
import com.alura.foroHub.domain.repository.TopicRepository;

public class TopicRepositoryJpaImpl implements TopicRepository {

    private final TopicRepositoryJpa jpa;

    public TopicRepositoryJpaImpl(TopicRepositoryJpa jpa) {
        this.jpa = jpa;
    }

    @Override
    public void save(TopicEntity topicEntity) {
        TopicEntity topicEntity = mapper.
    }
}
