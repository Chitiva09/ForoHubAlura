package com.alura.foroHub.application.mapper;

import com.alura.foroHub.application.dto.authentication.CreateUserDtoEntrance;
import com.alura.foroHub.domain.model.UserModel;
import com.alura.foroHub.domain.valueObject.userModelVO.EmailVO;
import com.alura.foroHub.domain.valueObject.userModelVO.UserNameVO;
import com.alura.foroHub.domain.valueObject.userModelVO.UserPasswordVO;

public class UserAppMapper {

    public static UserModel toDomain (CreateUserDtoEntrance dto, String hashedPassword){

        return new UserModel().builder()
                .withUserName(new UserNameVO(dto.userName()))
                .withEmail(new EmailVO(dto.email()))
                .withUserPassword(new UserPasswordVO(hashedPassword))
                .build();


    }


}
