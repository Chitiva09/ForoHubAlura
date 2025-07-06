package com.alura.foroHub.domain.model;


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
public class Course {
    @Id
    private Long id;
    private String nameCourse;
    private String category;

    @OneToMany(mappedBy = "course")
    private List<Topic> topics;
}
