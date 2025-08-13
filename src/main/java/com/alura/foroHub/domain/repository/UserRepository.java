package com.alura.foroHub.domain.repository;

import com.alura.foroHub.domain.model.UserModel;

public interface UserRepository {

    UserModel findByUserName(String userName);

    void save(UserModel userModel);
}
