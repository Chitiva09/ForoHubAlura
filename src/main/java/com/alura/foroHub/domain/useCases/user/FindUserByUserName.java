package com.alura.foroHub.domain.useCases.user;

import com.alura.foroHub.domain.model.UserModel;


public interface FindUserByUserName {

    UserModel execute(String userName);


}
