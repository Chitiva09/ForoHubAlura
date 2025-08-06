package com.alura.foroHub.infrastructure.persistence.topic;



import com.alura.foroHub.domain.model.Topic;
import com.alura.foroHub.domain.repository.TopicRepository;
import com.alura.foroHub.infrastructure.entity.CourseEntity;
import com.alura.foroHub.infrastructure.entity.TopicEntity;
import com.alura.foroHub.infrastructure.mapper.CourseInfraMapper;
import com.alura.foroHub.infrastructure.mapper.TopicInfraMapper;

import java.util.List;
import java.util.Optional;


public class TopicRepositoryJpaAdapter implements TopicRepository {

    private final TopicRepositoryJpa jpa;



    public TopicRepositoryJpaAdapter(TopicRepositoryJpa jpa) {
        this.jpa = jpa;

    }

    @Override
    public void save(Topic topicDomain, Long idCourse) {
        CourseEntity courseEntity = CourseInfraMapper.toEntity(idCourse);
        TopicEntity topicEntity = TopicInfraMapper.toEntity(topicDomain, courseEntity);
        jpa.save(topicEntity);

    }

    @Override
    public List<Topic> findAll(){
    List<TopicEntity> topics = jpa.findAll();
        return TopicInfraMapper.toDomainList(topics);
    }

    @Override
    public Optional<Topic> findById(Long idTopic) {

        return  jpa.findById(idTopic)
                .map(TopicInfraMapper::searchByIdToDomain);
    }
}
