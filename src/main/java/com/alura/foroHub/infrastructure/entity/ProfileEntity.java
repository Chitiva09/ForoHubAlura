package com.alura.foroHub.infrastructure.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity(name = "Profile")
@Table(name = "profile")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Builder
public class ProfileEntity {

    @Id
    private Long id;
    private String nameProfile;
    @ManyToMany(mappedBy = "profileEntities")
    private List<UserEntity> userEntities;

}
