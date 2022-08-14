package com.example.cinemahoanghuy.service.serviceImpl;

import com.example.cinemahoanghuy.entity.Permission;
import com.example.cinemahoanghuy.entity.Role;
import com.example.cinemahoanghuy.repo.PermissionRepository;
import com.example.cinemahoanghuy.repo.RoleRepository;
import com.example.cinemahoanghuy.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class RoleService implements IRoleService {

    @Autowired
    private PermissionRepository permissionRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Optional<Role> findById(Long id) {
        return roleRepository.findById(id);
    }

    @Override
    public Role saveOrUpdate(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public void delete(Role role) {
        roleRepository.delete(role);
    }

    @Override
    public void delete(Long id) {
        roleRepository.deleteById(id);
    }

    @Override
    public Role findRoleByName(String name) {
        return roleRepository.findByName(name).get();
    }

    @Override @Transactional
    public void addPermissionToRole(String roleName, String perName) {
        Role role = roleRepository.findByName(roleName).get();
        Permission permission = permissionRepository.findByName(perName);
        role.getPermissions().add(permission);
    }
}
