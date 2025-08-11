package com.alura.foroHub.infrastructure.security;

import com.alura.foroHub.domain.model.UserModel;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import org.springframework.beans.factory.annotation.Value;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

public class TokenService {

    @Value("${api.security.token.secret}")
//con esta línea obtengo el secret de properties y se lo inyecto a la variable secret
    private String secret;

    public String generateToken(UserModel userModel) {

        try {
            var algorithm = Algorithm.HMAC256(secret);
            return JWT.create()
                    .withIssuer("API ForoHub")
                    .withSubject(userModel.getUserName().getUserName())
                    .withExpiresAt(expirationDate())
                    .sign(algorithm);
        } catch (JWTCreationException exception) {
            throw new RuntimeException("Error al generar el token JWT");
        }

    }

    private Instant expirationDate() {
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.UTC);
    }

    public String getSubject(String tokenJWT) {
        try {
            var algorithm = Algorithm.HMAC256(secret);
            return JWT.require(algorithm)
                    // specify any specific claim validations
                    .withIssuer("API ForoHub")
                    // reusable verifier instance
                    .build()
                    .verify(tokenJWT)
                    .getSubject();

        } catch (JWTVerificationException exception) {
            throw new RuntimeException("Token JWT invalido o expirado");
        }

    }
}
