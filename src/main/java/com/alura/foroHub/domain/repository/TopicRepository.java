package com.alura.foroHub.domain.repository;

import com.alura.foroHub.domain.model.Course;
import com.alura.foroHub.domain.model.Topic;

import java.util.List;
import java.util.Optional;

public interface TopicRepository {
    void save(Topic topic, Long  idCourse);
    List<Topic> findAll ();
    Optional<Topic> findById (Long idTopic);

}
