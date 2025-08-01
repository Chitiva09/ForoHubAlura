package com.alura.foroHub.infrastructure.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity(name = "Answers")
@Table(name = "answers")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Builder
public class AnswersEntity {

    @Id
    private Long id;
    private String message;
    private LocalDateTime creationDate;
    private String author;
    private String solution;
    
    @ManyToOne
    @JoinColumn(name = "topic_id")
    private TopicEntity topicEntity;
    @ManyToOne
    @JoinColumn(name = "app_user_id")
    private UserEntity userEntity;

}
