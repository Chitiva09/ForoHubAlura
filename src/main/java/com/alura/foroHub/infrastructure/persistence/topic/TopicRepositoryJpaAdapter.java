package com.alura.foroHub.infrastructure.persistence.topic;



import com.alura.foroHub.domain.model.Topic;
import com.alura.foroHub.domain.repository.TopicRepository;
import com.alura.foroHub.infrastructure.entity.CourseEntity;
import com.alura.foroHub.infrastructure.entity.TopicEntity;
import com.alura.foroHub.infrastructure.mapper.FindByNameCourseInfraMapper;
import com.alura.foroHub.infrastructure.mapper.NewTopicInfraMapper;
import com.alura.foroHub.infrastructure.mapper.TopicShowAllInfraMapper;

import java.util.List;
import java.util.stream.Collectors;


public class TopicRepositoryJpaAdapter implements TopicRepository {

    private final TopicRepositoryJpa jpa;
    private final NewTopicInfraMapper newTopicInfraMapper;
    private final FindByNameCourseInfraMapper findByNameCourseInfraMapper;
    private final TopicShowAllInfraMapper topicShowAllInfraMapper;

    public TopicRepositoryJpaAdapter(TopicRepositoryJpa jpa, NewTopicInfraMapper newTopicInfraMapper, FindByNameCourseInfraMapper findByNameCourseInfraMapper, TopicShowAllInfraMapper topicShowAllInfraMapper) {
        this.jpa = jpa;
        this.newTopicInfraMapper = newTopicInfraMapper;
        this.findByNameCourseInfraMapper = findByNameCourseInfraMapper;
        this.topicShowAllInfraMapper = topicShowAllInfraMapper;
    }


    public void save(Topic topicDomain, Long idCourse) {
        CourseEntity courseEntity = findByNameCourseInfraMapper.toEntity(idCourse);
        TopicEntity topicEntity = newTopicInfraMapper.toEntity(topicDomain, courseEntity);
        jpa.save(topicEntity);

    }

    public List<Topic> findAll(){
    List<TopicEntity> topics = jpa.findAll();
        return topicShowAllInfraMapper.toDomainList(topics);
    }


}
