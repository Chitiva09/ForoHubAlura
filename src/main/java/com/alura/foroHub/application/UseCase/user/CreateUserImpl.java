package com.alura.foroHub.application.UseCase.user;

import com.alura.foroHub.application.dto.authentication.CreateUserDtoEntrance;
import com.alura.foroHub.application.mapper.UserAppMapper;
import com.alura.foroHub.domain.model.UserModel;
import com.alura.foroHub.domain.repository.UserRepository;
import com.alura.foroHub.domain.useCases.user.CreateUser;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;

@RequiredArgsConstructor
public class CreateUserImpl implements CreateUser {
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    @Override
   public void execute (CreateUserDtoEntrance dto){

        String hashedPassword = passwordEncoder.encode(dto.password());
        System.out.println("contraseña encriptada"+ hashedPassword);

        UserModel userModel = UserAppMapper.toDomain(dto,hashedPassword);

        userRepository.save(userModel);
   }
}
