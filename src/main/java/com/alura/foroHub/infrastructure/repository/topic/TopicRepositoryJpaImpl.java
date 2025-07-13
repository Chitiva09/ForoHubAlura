package com.alura.foroHub.infrastructure.repository.topic;

import com.alura.foroHub.domain.model.Topic;
import com.alura.foroHub.domain.repository.TopicRepository;
import org.springframework.stereotype.Repository;

@Repository
public class TopicRepositoryJpaImpl implements TopicRepository {

    private final TopicRepositoryJpa jpa;

    public TopicRepositoryJpaImpl(TopicRepositoryJpa jpa) {
        this.jpa = jpa;
    }

    @Override
    public void save(Topic topic) {

    }
}
