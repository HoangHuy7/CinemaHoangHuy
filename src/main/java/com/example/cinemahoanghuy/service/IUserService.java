package com.example.cinemahoanghuy.service;

import com.example.cinemahoanghuy.entity.User;

public interface IUserService extends IGeneralService<User>{

    User findByUsername(String username);

    void addRoleToUser(String username,String roleName);
}
