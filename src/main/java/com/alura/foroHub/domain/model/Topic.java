package com.alura.foroHub.domain.model;


import com.alura.foroHub.application.dto.TopicDto;
import com.alura.foroHub.application.mapper.TopicMapper;
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
public class Topic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String Title;
    private String message;
    private LocalDateTime creationDate;
    private boolean status = true;
    private String author ;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    @OneToMany(mappedBy = "topic")
    private List<Answers> answers;

    @ManyToOne
    @JoinColumn(name = "app_user_id")
    private UserEntity userEntity;

}
