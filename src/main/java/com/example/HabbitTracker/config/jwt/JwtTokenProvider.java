package com.example.HabbitTracker.config.jwt;


import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.ZonedDateTime;
import java.util.Date;

@Component
@RequiredArgsConstructor
@Getter
@Setter
public class JwtTokenProvider {

    @Value("${jwt.token.issuer}")
    private String issuer;

    @Value("${jwt.token.secret}")
    private String secretWord;

    @Value("${jwt.token.expired}")
    private String expiresAt;

    public String generateToken(String email) {
        return JWT.create().withIssuer(issuer).withExpiresAt(new Date()).withClaim("email", email).withExpiresAt(Date.from(ZonedDateTime.now().plusDays(Long.parseLong(expiresAt)).toInstant())).sign(Algorithm.HMAC512(secretWord));
    }

    public String verifyToken(String token) {
        return JWT.require(Algorithm.HMAC512(secretWord)).withIssuer(issuer).build().verify(token).getClaim("email").asString();
    }
}