package com.alura.foroHub.infrastructure.persistence.user;

import com.alura.foroHub.infrastructure.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepositoryJpa extends JpaRepository<UserEntity, Long>{}
