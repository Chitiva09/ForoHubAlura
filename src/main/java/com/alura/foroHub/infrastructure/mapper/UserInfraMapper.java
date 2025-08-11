package com.alura.foroHub.infrastructure.mapper;

import com.alura.foroHub.domain.model.UserModel;
import com.alura.foroHub.domain.valueObject.userModelVO.EmailVO;
import com.alura.foroHub.domain.valueObject.userModelVO.UserNameVO;
import com.alura.foroHub.domain.valueObject.userModelVO.UserPasswordVO;
import com.alura.foroHub.infrastructure.entity.UserEntity;

public class UserInfraMapper {

    public static UserModel toModel(UserEntity user) {

        UserModel.UserModelBuilder userBuilder = UserModel.builder()
                .withId(user.getId())
                .withUserName(new UserNameVO(user.getUserName()))
                .withUserPassword(new UserPasswordVO(user.getUserPassword()))
                .withEmail(new EmailVO(user.getEmail()));

        return userBuilder.build();
    }


}
