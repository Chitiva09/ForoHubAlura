package com.alura.foroHub.infrastructure.persistence.topic;

import com.alura.foroHub.infrastructure.entity.TopicEntity;
import org.springframework.data.jpa.repository.JpaRepository;



public interface TopicRepositoryJpa extends JpaRepository<TopicEntity, Long> {

}
