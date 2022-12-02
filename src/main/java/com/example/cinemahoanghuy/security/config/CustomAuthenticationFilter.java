package com.example.cinemahoanghuy.security.config;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.cinemahoanghuy.dto.TTokenDTO;
import com.example.cinemahoanghuy.entity.Token;
import com.example.cinemahoanghuy.entity.User;
import com.example.cinemahoanghuy.security.UserPrincipal;
import com.example.cinemahoanghuy.service.serviceImpl.TokenService;
import com.example.cinemahoanghuy.service.serviceImpl.UserService;
import com.example.cinemahoanghuy.util.JwtUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.context.ApplicationContext;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Slf4j
public class CustomAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
    private final AuthenticationManager authenticationManager;
    private final TokenService tokenService;
    private final UserService userService;
    private final ModelMapper modelMapper;
    private final JwtUtil jwtUtil;

    public CustomAuthenticationFilter(AuthenticationManager authenticationManager, ApplicationContext ctx) {
        this.authenticationManager = authenticationManager;
        this.tokenService = ctx.getBean(TokenService.class);
        this.userService = ctx.getBean(UserService.class);
        this.modelMapper = ctx.getBean(ModelMapper.class);
        this.jwtUtil = ctx.getBean(JwtUtil.class);
    }


    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        log.info("Username authentication is {}", password);
        log.info("Password authentication is {}", username);
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(username, password);
        return authenticationManager.authenticate(usernamePasswordAuthenticationToken);
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException {
        UserPrincipal user = (UserPrincipal) authResult.getPrincipal();
        String access_token;
        String refresh_token;
        Token token = tokenService.findByUserId(user.getId());

        String username = user.getUsername();
        if (token == null) {
            log.warn("username: {} chua co token nen bay h phai tao",username);
            // Tạo mới token khi user ko có token nào trong database
            List<String> authorityList = user.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList());

            access_token = jwtUtil.createAccessToken(username, request.getRequestURL().toString(), authorityList);
            refresh_token = jwtUtil.createRefreshToken(username, authorityList);


            User userInToken = userService.findByUsername(user.getUsername()).get();
            token = Token.builder().access_token(access_token).refresh_token(refresh_token).user(userInToken).build();
            tokenService.save(token);
            log.warn("Đã lưu token của user {} vào database", username);
        } else {
            log.warn("Tim thay user: {} trong token va bay h tien hanh kiem tra",username);
            // Kiểm tra refresh token có hạn sử dụng, hết thì tạo mới 2 cái
            DecodedJWT decodedJWT = jwtUtil.validatorJwt(token.getRefresh_token());
            if (decodedJWT == null) {
                log.warn("refresh token user: {} het han nen bh tao lai",username);
                List<String> authorityList = user
                        .getAuthorities()
                        .stream()
                        .map(GrantedAuthority::getAuthority)
                        .collect(Collectors.toList());


                access_token = jwtUtil.createAccessToken(username, request.getRequestURL().toString(), authorityList);
                refresh_token = jwtUtil.createRefreshToken(username, authorityList);
                token.setAccess_token(access_token);
                token.setRefresh_token(refresh_token);
                token.setUpdateDate(new Date(System.currentTimeMillis()));
                tokenService.save(token);
                log.warn("Đã chỉnh sửa token của user {} ở database", username);
            }

        }
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "GET, PUT, POST, DELETE, OPTIONS");
        response.setHeader("Access-Control-Allow-Headers", "DNT,X-CustomHeader,Keep-Alive,User-Agent,X-Requested-With,If-Modified-Since,Cache-Control,Content-Type,Content-Range,Range");
        response.setContentType(APPLICATION_JSON_VALUE);


        new ObjectMapper().writeValue(response.getOutputStream(), modelMapper.map(token, TTokenDTO.class));
    }
}
