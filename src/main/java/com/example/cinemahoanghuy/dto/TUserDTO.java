package com.example.cinemahoanghuy.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class TUserDTO {
    private String username;
    private String fullName;
    private Set<TRoleDTO> roles;
}
