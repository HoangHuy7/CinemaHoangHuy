package com.example.cinemahoanghuy.api;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.cinemahoanghuy.entity.User;
import com.example.cinemahoanghuy.security.UserPrincipal;
import com.example.cinemahoanghuy.service.IUserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/api/v1/token")
@Slf4j
public class AuthenController {

    private String jwtSecret = "huydeptraivodich";

    @Autowired
    private IUserService userService;

    @GetMapping("/refresh")
    public void refreshToken(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String authorizationHeader = request.getHeader(AUTHORIZATION);
        Map<String, String> resultResponse = new HashMap<>();
        response.setContentType(APPLICATION_JSON_VALUE);
        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            try {
                String refresh_token = authorizationHeader.substring(("Bearer ").length());
                Algorithm algorithm = Algorithm.HMAC256(jwtSecret.getBytes());
                JWTVerifier jwtVerifier = JWT.require(algorithm).build();
                DecodedJWT decodedJWT = jwtVerifier.verify(refresh_token);

                // check refresh token
                String toke_name = decodedJWT.getClaim("toke_name").asString();
                if (toke_name.equals("access_token")) {

                    log.error("This is access token, pls enter refresh token");
                    resultResponse.put("error","This is access token, pls enter refresh token");
                    new ObjectMapper().writeValue(response.getOutputStream(),resultResponse );
                    return;
                }


                String username = decodedJWT.getSubject();
                User user = userService.findByUsername(username);
                UserPrincipal userPrincipal = UserPrincipal.build(user);
                String access_token = JWT.create()
                        .withSubject(user.getUsername())
                        .withExpiresAt(new Date(System.currentTimeMillis() + 10 * 60 * 1000))
                        .withIssuer(request.getRequestURL().toString())
                        .withClaim("roles", userPrincipal.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList()))
                        .sign(algorithm);

                resultResponse.put("access_token", access_token);
                resultResponse.put("refresh_token", refresh_token);
                new ObjectMapper().writeValue(response.getOutputStream(), resultResponse);


            } catch (IOException e) {
                log.error("Error is : {}", e.getMessage());
                resultResponse.put("error_message", e.getMessage());
                response.setStatus(HttpStatus.FORBIDDEN.value());
                response.setHeader("error", e.getMessage());
                new ObjectMapper().writeValue(response.getOutputStream(), resultResponse);
            }
        } else {
            throw new RuntimeException("Bad jwt token");
        }


    }
}
