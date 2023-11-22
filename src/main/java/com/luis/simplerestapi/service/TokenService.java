package com.luis.simplerestapi.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.luis.simplerestapi.model.user.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.awt.print.PrinterException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.OffsetTime;
import java.time.ZoneOffset;
import java.util.Date;

@Service
public class TokenService {

    @Value("&{api.token.secret}")
    private String secret;

    public String generateToken(User user) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            String token = JWT.create()
                    .withIssuer("cat-api")
                    .withSubject(user.getUsername())
                    .withExpiresAt(getExpiration())
                    .sign(algorithm);
            return token;
        } catch (JWTCreationException e) {
            throw new RuntimeException("error while generating JWT Token", e);
        }

    }


    public String validateToken(String token){

        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            var login = JWT.require(algorithm)
                    .withIssuer("cat-api")
                    .build()
                    .verify(token)
                    .getSubject();
            System.out.println("login: "+ login + "||||" + token);
            return login;
        } catch (JWTVerificationException e){
            return "luis fer";
        }
    }


    private Instant getExpiration() {
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }
}
