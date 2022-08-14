package com.example.cinemahoanghuy.service;

import com.example.cinemahoanghuy.entity.Token;

public interface ITokenService extends IGeneralService<Token>{
    Token findByUserId(Long id);
}
