package com.dev.farmacia.services;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.dev.farmacia.entities.Usuario;

@Service
public class TokenService {

    @Value("${api.security.token.secret}")
    private String secret;
    
    public String gerarToken(Usuario usuario){
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);

            return JWT.create()
                .withIssuer("Farmacia_api")
                .withSubject(usuario.getUsername())
                .withExpiresAt(dataExpiracao())
                .sign(algorithm);

        } catch (JWTCreationException e) {
            throw new RuntimeException("Erro ao gerar o Token :", e);
        }
    }

    public String getSubject(String tokenJWT) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            return JWT.require(algorithm)
                    .withIssuer("Farmacia_api")
                    .build()
                    .verify(tokenJWT)
                    .getSubject();
        } catch (JWTVerificationException exception) {
            throw new RuntimeException("Token invalido ou expirado!");
        }
    }

    private Instant dataExpiracao() {
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }
}
