package com.example.cinemahoanghuy.service.serviceImpl;

import com.example.cinemahoanghuy.entity.Token;
import com.example.cinemahoanghuy.repo.TokenRepository;
import com.example.cinemahoanghuy.repo.UserRepository;
import com.example.cinemahoanghuy.service.ITokenService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@Transactional
public class TokenService implements ITokenService {

    @Autowired
    private  TokenRepository tokenRepository;
    @Autowired
    private  UserRepository userRepository;

    @Override
    public Token findByUserId(Long id) {
        return tokenRepository.findByUserId(id).orElse(null);
    }



    @Override
    public List<Token> findALl() {
        return tokenRepository.findAll();
    }

    @Override
    public Optional<Token> findById(Long id) {
        return tokenRepository.findById(id);
    }

    @Override
    public Token save(Token token) {
        return tokenRepository.save(token);
    }

    @Override
    public void delete(Token token) {
        tokenRepository.delete(token);
    }

    @Override
    public void delete(Long id) {
        tokenRepository.deleteById(id);
    }

    @Override @Transactional
    public Token update(Token token) {
        Token tokenOld = tokenRepository.findById(token.getId()).get();
        tokenOld.setAccess_token(token.getAccess_token());
        tokenOld.setRefresh_token(token.getRefresh_token());
        return tokenOld;
    }


}
