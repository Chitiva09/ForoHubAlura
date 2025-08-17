package com.alura.foroHub.infrastructure.persistence.topic;



import com.alura.foroHub.domain.model.Course;
import com.alura.foroHub.domain.model.Topic;
import com.alura.foroHub.domain.repository.TopicRepository;
import com.alura.foroHub.infrastructure.entity.CourseEntity;
import com.alura.foroHub.infrastructure.entity.TopicEntity;
import com.alura.foroHub.infrastructure.mapper.CourseInfraMapper;
import com.alura.foroHub.infrastructure.mapper.TopicInfraMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class TopicRepositoryJpaAdapter implements TopicRepository {

    private final TopicRepositoryJpa jpa;

    @Override
    public Topic save(Topic topicDomain, Course Course) {
        CourseEntity courseEntity = CourseInfraMapper.toEntity(Course);
        TopicEntity topicEntity = TopicInfraMapper.toEntity(topicDomain, courseEntity);
        TopicEntity savedTopic = jpa.save(topicEntity);
        return TopicInfraMapper.toDomain(savedTopic);
    }

    @Override
    public Page<Topic> findAll(Pageable pageable){
    Page<TopicEntity> topics = jpa.findAll(pageable);
        return TopicInfraMapper.toDomainList(topics);
    }

    @Override
    public Optional<Topic> findById(Long idTopic) {

        return  jpa.findById(idTopic)
                .map(TopicInfraMapper::toDomain);
    }

    @Override
    public void deleteById (Long id){
        jpa.deleteById(id);
    }

    //Debo revisar por que la fecha de creacion esta llegando null
}
