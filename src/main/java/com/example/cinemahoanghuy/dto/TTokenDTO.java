package com.example.cinemahoanghuy.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TTokenDTO {

    private Long userId;
    private String accessToken;
    private String refreshToken;
    private TUserDTO user;

}
