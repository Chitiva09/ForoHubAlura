package com.alura.foroHub.domain.repository;

import com.alura.foroHub.application.dto.TopicDto;
import com.alura.foroHub.domain.model.Topic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicRepository extends JpaRepository<Topic, Long> {



}
