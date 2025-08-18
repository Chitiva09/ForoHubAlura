package com.alura.foroHub.infrastructure.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity(name = "User_Model")
@Table(name = "user_model")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Builder
public class UserEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userName;
    private String email;
    private String userPassword;

    @ManyToMany
    @JoinTable(
            name = "user_profile",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "profile_id")
    )
    private List<ProfileEntity> profileEntities;

    @OneToMany(mappedBy = "userEntity")
    private List<TopicEntity> topicEntities;


}
