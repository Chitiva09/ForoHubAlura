package com.alura.foroHub.infrastructure.repository.topic;

import com.alura.foroHub.domain.model.Topic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicRepositoryJpa extends JpaRepository<Topic, Long> {


}
