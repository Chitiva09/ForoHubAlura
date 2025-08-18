package com.alura.foroHub.infrastructure.persistence.user;

import com.alura.foroHub.domain.model.UserModel;
import com.alura.foroHub.domain.repository.UserRepository;
import com.alura.foroHub.infrastructure.entity.UserEntity;
import com.alura.foroHub.infrastructure.mapper.UserInfraMapper;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
public class UserRepositoryJpaAdapter implements UserRepository {

    private final UserRepositoryJpa jpa;

    @Override
    public UserModel findByUserName(String userName) {

        UserEntity userEntity = jpa.findByUserName(userName);

        return UserInfraMapper.toModel(userEntity);
    }

    @Override
    public void save(UserModel userModel) {
        UserEntity userEntity = UserInfraMapper.toEntity(userModel);
        jpa.save(userEntity);
    }

}
