package com.example.cinemahoanghuy.service;

import com.example.cinemahoanghuy.entity.Role;

public interface IRoleService extends IGeneralService<Role>{

    Role findRoleByName(String name);

    void addPermissionToRole(String roleName,String perName);
}
