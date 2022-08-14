package com.example.cinemahoanghuy.security.service;

import com.example.cinemahoanghuy.entity.User;
import com.example.cinemahoanghuy.repo.UserRepository;
import com.example.cinemahoanghuy.security.UserPrincipal;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class UserDetailService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByUsername(username);
        if (!user.isPresent()){
            log.info(String.format("Ko Tìm thấy user %s in database",username));
            throw new UsernameNotFoundException("tien dang nhap sai");

            //           return  null;
        }
        else {
            log.info(String.format("Tìm thấy user %s in database",username));
        }
        return UserPrincipal.build(user.get());
    }
}
