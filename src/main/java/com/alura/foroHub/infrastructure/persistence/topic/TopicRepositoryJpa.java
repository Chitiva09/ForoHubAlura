package com.alura.foroHub.infrastructure.persistence.topic;

import com.alura.foroHub.domain.model.Course;
import com.alura.foroHub.infrastructure.entity.TopicEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


public interface TopicRepositoryJpa extends JpaRepository<TopicEntity, Long> {

}
