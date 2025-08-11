package com.alura.foroHub.infrastructure.configuration;


import com.alura.foroHub.application.UseCase.FindUserByUserNameImpl;
import com.alura.foroHub.domain.repository.UserRepository;
import com.alura.foroHub.domain.useCases.FindUserByUserName;
import com.alura.foroHub.infrastructure.persistence.user.UserRepositoryJpa;
import com.alura.foroHub.infrastructure.persistence.user.UserRepositoryJpaAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserBeansConfiguration {

    @Bean
    public UserRepository userRepository(UserRepositoryJpa jpa) {

        return new UserRepositoryJpaAdapter(jpa);


    }

    public FindUserByUserName findUserByUserName(UserRepository userRepository) {
        return new FindUserByUserNameImpl(userRepository);
    }

}
