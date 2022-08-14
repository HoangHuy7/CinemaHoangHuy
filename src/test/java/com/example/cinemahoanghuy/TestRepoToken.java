package com.example.cinemahoanghuy;

import com.example.cinemahoanghuy.entity.Token;
import com.example.cinemahoanghuy.repo.TokenRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class TestRepoToken {

    @Autowired
    private TokenRepository tokenRepository;

    @Test
    public void testMethod() {
        Token token = null;
        token = tokenRepository.findByUserId(1L);
        log.warn(token.toString());
        Assertions.assertNotNull(token);


    }
}
