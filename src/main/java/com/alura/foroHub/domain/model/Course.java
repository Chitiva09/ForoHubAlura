package com.alura.foroHub.domain.model;


import com.alura.foroHub.infrastructure.entity.TopicEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Course {

    private Long id;
    private String nameCourse;
    private String category;
    private List<TopicEntity> topicEntities;

}
