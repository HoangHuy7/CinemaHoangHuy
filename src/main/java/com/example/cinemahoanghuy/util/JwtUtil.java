package com.example.cinemahoanghuy.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Component
@Slf4j
public class JwtUtil {
    @Value("${cinemaHuy.app.jwtSecret}")
    private String JWT_SECRET;

    @Value("${cinemaHuy.app.expiry.access_token}")
    private Long EXPIRY_ACCESS_TOKEN;

    @Value("${cinemaHuy.app.expiry.refresh_token}")
    private Long EXPIRY_REFRESH_TOKEN;
    public DecodedJWT validatorJwt(String authorizationToken){
        try {
            Algorithm algorithm = Algorithm.HMAC256(JWT_SECRET.getBytes());
            JWTVerifier jwtVerifier = JWT.require(algorithm).build();
            DecodedJWT decodedJWT = jwtVerifier.verify(authorizationToken);
            return decodedJWT;
        }catch (Exception e){
            log.error(e.getMessage());
        }
        return null;
    }

    public String createAccessToken(String username, String issuer, List<String> listRole){
        Algorithm algorithm = Algorithm.HMAC256(JWT_SECRET.getBytes());
        String access_token = JWT.create()
                .withSubject(username)
                .withExpiresAt(new Date(System.currentTimeMillis() + EXPIRY_ACCESS_TOKEN))
                .withIssuer(issuer)
                .withClaim("token_name", "access_token")
                .withClaim("roles", listRole)
                .sign(algorithm);
        return access_token;
    }

    public String createRefreshToken(String username, List<String> listRole){
        Algorithm algorithm = Algorithm.HMAC256(JWT_SECRET.getBytes());
        String refresh_token = JWT.create()
                .withSubject(username)
                .withClaim("token_name", "refresh_token")
                .withExpiresAt(new Date(System.currentTimeMillis() + EXPIRY_REFRESH_TOKEN))
                .withClaim("roles", listRole)
                .sign(algorithm);
        return refresh_token;
    }

}
