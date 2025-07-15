package com.alura.foroHub.infrastructure.entity;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity(name = "Course")
@Table(name = "course")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class CourseEntity {
    @Id
    private Long id;
    private String nameCourse;
    private String category;

    @OneToMany(mappedBy = "courseEntity")
    private List<TopicEntity> topicEntities;

}
