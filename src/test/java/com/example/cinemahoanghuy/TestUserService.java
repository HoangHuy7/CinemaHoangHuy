package com.example.cinemahoanghuy;
import com.example.cinemahoanghuy.security.UserPrincipal;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UserDetailsService;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@SpringBootTest
public class TestUserService {

    @Autowired
    private UserDetailsService userDetailsService;

    @Test
    public void testUserDetailServiceIsNotNull(){
        log.info("Đang test user service");
        String username = "huy";
        UserPrincipal user = (UserPrincipal) userDetailsService.loadUserByUsername(username);
        assertNotNull(user);
    }

}
