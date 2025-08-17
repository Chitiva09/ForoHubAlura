package com.alura.foroHub.domain.repository;

import com.alura.foroHub.domain.model.Course;
import com.alura.foroHub.domain.model.Topic;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface TopicRepository {
    Topic save(Topic topic, Course course);
    Page<Topic> findAll (Pageable pageable);
    Optional<Topic> findById (Long idTopic);
    void deleteById (Long idTopic);

}
