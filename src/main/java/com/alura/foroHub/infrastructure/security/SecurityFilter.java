package com.alura.foroHub.infrastructure.security;


import com.alura.foroHub.domain.repository.UserRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@RequiredArgsConstructor
public class SecurityFilter extends OncePerRequestFilter {
    private final CustomUserDetails customUserDetails;
    private final UserRepository userRepository;
    private final TokenService tokenService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String tokenJWT = recoverToken(request);//aca asigno eel token que obtube en el metodo a esta variable
        if (tokenJWT != null) {//si el token viene en la variable
            String subjet = tokenService.getSubject(tokenJWT);// obtengo el subject desde la clase ToenService
            var userValidator = userRepository.findByUserName(subjet);//Obtengo el usuario desde la base de datos
            //creo una autenticacion que se le envia a setAuthentication
            var authentication = new UsernamePasswordAuthenticationToken(userValidator, null, customUserDetails.getAuthorities());

            SecurityContextHolder.getContext().setAuthentication(authentication);//esto es para autenticarun usuario
        }

        filterChain.doFilter(request, response);

    }

    private String recoverToken(HttpServletRequest request) {
        String authorizationHeader = request.getHeader("Authorization");// obtengo el encabezado
        if (authorizationHeader != null) { //si el encabezado tiene un token entonces obtengo el token y elimino el bearer para mandar solo el token
            return authorizationHeader.replace("Bearer ", "");
        }
        return null;
    }
}
