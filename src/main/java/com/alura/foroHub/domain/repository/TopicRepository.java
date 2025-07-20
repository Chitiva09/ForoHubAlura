package com.alura.foroHub.domain.repository;

import com.alura.foroHub.domain.model.Course;
import com.alura.foroHub.domain.model.Topic;

public interface TopicRepository {
    void save(Topic topic, Course courseDomain);

}
