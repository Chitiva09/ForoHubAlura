package com.alura.foroHub.infrastructure.entity;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;


@Entity(name = "Topic")
@Table(name = "topic")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class TopicEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String message;
    private LocalDateTime creationDate;
    private boolean status = true;
    private String author ;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private CourseEntity courseEntity;

    @OneToMany(mappedBy = "topicEntity")
    private List<AnswersEntity> answers;

    @ManyToOne
    @JoinColumn(name = "app_user_id")
    private UserEntity userEntity;

}
