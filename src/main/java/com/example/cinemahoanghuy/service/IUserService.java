package com.example.cinemahoanghuy.service;

import com.example.cinemahoanghuy.entity.User;

import java.util.Optional;

public interface IUserService extends IGeneralService<User>{

    Optional<User> findByUsername(String username);

    void addRoleToUser(String username,String roleName);
}
