package com.alura.foroHub.infrastructure.security;


import com.alura.foroHub.domain.model.UserModel;
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
    private final UserRepository userRepository;
    private final TokenService tokenService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String tokenJWT = recoverToken(request);//aca asigno eel token que obtube en el metodo a esta variable
        if (tokenJWT != null) {//si el token viene en la variable
            String subjet = tokenService.getSubject(tokenJWT);// obtengo el subject desde la clase ToenService
            UserModel userValidator = userRepository.findByUserName(subjet);//Obtengo el usuario desde la base de datos

            //   if (userValidator.isPresent())
            //creo una autenticacion que se le envia a setAuthentication
            var authentication = new UsernamePasswordAuthenticationToken(userValidator, null, new CustomUserDetails(userValidator).getAuthorities());
            System.out.println("esta es la info que lleva authentication " + authentication);

            //estoy revisando por que aca me llega null
            SecurityContextHolder.getContext().setAuthentication(authentication);//esto es para autenticarun usuario
        }

        filterChain.doFilter(request, response);

    }
    //sobreescribiendo este metodo hago que no pida el autentication del encabezado para las rutas establecidas
    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
        String path = request.getServletPath();
        return path.equals("/login") || path.equals("/login/createUser");
    }
    private String recoverToken(HttpServletRequest request) {
        String authorizationHeader = request.getHeader("Authorization");// obtengo el encabezado
        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) { //si el encabezado tiene un token entonces obtengo el token y elimino el bearer para mandar solo el token
            return authorizationHeader.substring(7).trim();
        }
        return null;
    }
}
