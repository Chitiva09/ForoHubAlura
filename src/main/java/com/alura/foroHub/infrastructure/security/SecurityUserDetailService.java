package com.alura.foroHub.infrastructure.security;

import com.alura.foroHub.application.exception.UserNotFoundException;
import com.alura.foroHub.domain.model.UserModel;
import com.alura.foroHub.domain.useCases.user.FindUserByUserName;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
//AuthenticationManager llama esta clase la cual implementa UserDetailsService para hacer la busqueda del usuario en la base de datos

@RequiredArgsConstructor
public class SecurityUserDetailService implements UserDetailsService {
    private final FindUserByUserName findUserByUserName;

    //El metodo loadUserByUsername debe llamarse asi porque es un metodo establecido por UserDetailsService
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

        try {
            UserModel userModel = findUserByUserName.execute(userName);
            return new CustomUserDetails(userModel);

        } catch (UserNotFoundException e) {
            throw new UsernameNotFoundException("Usuario no encontrado" + userName);
        }

    }


}
