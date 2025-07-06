package com.alura.foroHub.domain.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity(name = "User")
@Table(name = "app_user")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class UserEntity {


    @Id
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
    private List<Profile> profiles;

    @OneToMany(mappedBy = "userEntity")
    private List<Topic> topics;
}
