package com.alura.foroHub.infrastructure.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity(name = "App_User")
@Table(name = "app_user")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Builder
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
    private List<ProfileEntity> profileEntities;

    @OneToMany(mappedBy = "userEntity")
    private List<TopicEntity> topicEntities;


}
