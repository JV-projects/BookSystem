package com.booksystem.booksystem.config.seguranca;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.booksystem.booksystem.model.Credenciais;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {

    private static final String SECRET = "BOOKSYSTEM_API";

    public String gerarToken(Credenciais credenciais){
        try{
            Algorithm algorithm = Algorithm.HMAC256(SECRET);
            String token = JWT.create()
                    .withIssuer("booksystem-api")
                    .withSubject(credenciais.getUsername())
                    .withExpiresAt(genExpirationDate())
                    .sign(algorithm);
            return token;
        } catch (JWTCreationException exception){
            throw new RuntimeException("Erro ao criar token", exception);
        }
    }

    public String validarToken(String token){
        try {
            Algorithm algorithm = Algorithm.HMAC256(SECRET);
            return JWT.require(algorithm)
                    .withIssuer("booksystem-api")
                    .build()
                    .verify(token)
                    .getSubject();
        } catch (JWTVerificationException exception){
            return "Token inválido ou expirado";
        }
    }

    private Instant genExpirationDate(){
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }

}
