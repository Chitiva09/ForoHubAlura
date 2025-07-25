package com.alura.foroHub.infrastructure.repository.topic;

import com.alura.foroHub.infrastructure.entity.TopicEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TopicRepositoryJpa extends JpaRepository<TopicEntity, Long> {


}
