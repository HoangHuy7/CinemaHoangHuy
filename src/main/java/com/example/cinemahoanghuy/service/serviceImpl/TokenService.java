package com.example.cinemahoanghuy.service.serviceImpl;

import com.example.cinemahoanghuy.entity.Token;
import com.example.cinemahoanghuy.repo.TokenRepository;
import com.example.cinemahoanghuy.service.ITokenService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class TokenService implements ITokenService {

    private final TokenRepository tokenRepository;

    @Override
    public Token findByUserId(Long id) {
        return tokenRepository.findByUserId(id);
    }

    @Override
    public Optional<Token> findById(Long id) {
        return tokenRepository.findById(id);
    }

    @Override
    public Token saveOrUpdate(Token token) {
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
}
