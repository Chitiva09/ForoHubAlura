package com.alura.foroHub.domain.model;

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
public class Answers {

    @Id
    private Long id;
    private String message;
    @ManyToOne
    @JoinColumn(name = "topic_id")
    private Topic topic;
    private LocalDateTime creationDate;
    private String author;
    private String solution;
    @ManyToOne
    @JoinColumn(name = "app_user_id")
    private UserEntity userEntity;

}
