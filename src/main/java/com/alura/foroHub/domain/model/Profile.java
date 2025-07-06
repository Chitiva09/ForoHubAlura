package com.alura.foroHub.domain.model;

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
public class Profile {

    @Id
    private Long id;
    private String nameProfile;
    @ManyToMany(mappedBy = "profiles")
    private List<UserEntity> userEntities;

}
