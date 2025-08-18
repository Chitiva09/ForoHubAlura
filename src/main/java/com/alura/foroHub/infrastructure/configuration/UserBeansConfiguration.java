package com.alura.foroHub.infrastructure.configuration;


import com.alura.foroHub.application.UseCase.user.CreateUserImpl;
import com.alura.foroHub.application.UseCase.user.FindUserByUserNameImpl;
import com.alura.foroHub.domain.repository.UserRepository;
import com.alura.foroHub.domain.useCases.user.CreateUser;
import com.alura.foroHub.domain.useCases.user.FindUserByUserName;
import com.alura.foroHub.infrastructure.persistence.user.UserRepositoryJpa;
import com.alura.foroHub.infrastructure.persistence.user.UserRepositoryJpaAdapter;
import com.alura.foroHub.infrastructure.security.SecurityFilter;
import com.alura.foroHub.infrastructure.security.SecurityUserDetailService;
import com.alura.foroHub.infrastructure.security.TokenService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class UserBeansConfiguration {

    @Bean
    public UserRepository userRepository(UserRepositoryJpa jpa) {
        return new UserRepositoryJpaAdapter(jpa);
    }

    @Bean
    public FindUserByUserName findUserByUserName(UserRepository userRepository) {
        return new FindUserByUserNameImpl(userRepository);
    }

    @Bean
    public SecurityFilter securityFilter(UserRepository userRepository, TokenService tokenService) {
        return new SecurityFilter(userRepository, tokenService);
    }

    @Bean
    public TokenService tokenService() {
        return new TokenService();
    }

    @Bean
    public SecurityUserDetailService securityUserDetailService(FindUserByUserName findUserByUserName) {
        return new SecurityUserDetailService(findUserByUserName);
    }

    @Bean
    public CreateUser createUser(PasswordEncoder passwordEncoder, UserRepository userRepository) {
        return new CreateUserImpl(passwordEncoder, userRepository);
    }
}
