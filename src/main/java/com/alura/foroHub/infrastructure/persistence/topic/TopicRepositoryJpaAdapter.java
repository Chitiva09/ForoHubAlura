package com.alura.foroHub.infrastructure.persistence.topic;



import com.alura.foroHub.domain.model.Topic;
import com.alura.foroHub.domain.repository.TopicRepository;
import com.alura.foroHub.infrastructure.entity.CourseEntity;
import com.alura.foroHub.infrastructure.entity.TopicEntity;
import com.alura.foroHub.infrastructure.mapper.CourseInfraMapper;
import com.alura.foroHub.infrastructure.mapper.TopicInfraMapper;


public class TopicRepositoryJpaAdapter implements TopicRepository {

    private final TopicRepositoryJpa jpa;
    private final TopicInfraMapper topicInfraMapper;
    private final CourseInfraMapper courseInfraMapper;

    public TopicRepositoryJpaAdapter(TopicRepositoryJpa jpa, TopicInfraMapper topicInfraMapper, CourseInfraMapper courseInfraMapper) {
        this.jpa = jpa;
        this.topicInfraMapper = topicInfraMapper;
        this.courseInfraMapper = courseInfraMapper;
    }


    public void save(Topic topicDomain, Long idCourse) {
        CourseEntity courseEntity = courseInfraMapper.toEntity(idCourse);
        TopicEntity topicEntity = topicInfraMapper.toEntity(topicDomain, courseEntity);
        jpa.save(topicEntity);

    }


}
