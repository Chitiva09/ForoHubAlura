package com.alura.foroHub.application.UseCase;

import com.alura.foroHub.application.exception.UserNotFoundException;
import com.alura.foroHub.domain.model.UserModel;
import com.alura.foroHub.domain.repository.UserRepository;
import com.alura.foroHub.domain.useCases.FindUserByUserName;
import lombok.RequiredArgsConstructor;

//Este caso de uso lo utiliza el SecurityUserDetailsService para hacer su validation
@RequiredArgsConstructor
public class FindUserByUserNameImpl implements FindUserByUserName {

    private final UserRepository userRepository;

    @Override
    public UserModel execute(String userName) {
        UserModel userModel = userRepository.findByUserName(userName);
        if (userModel == null) {
            throw new UserNotFoundException(userName);
        }
        return userModel;


    }


}
