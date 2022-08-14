package com.example.cinemahoanghuy.service.serviceImpl;


import com.example.cinemahoanghuy.entity.Permission;
import com.example.cinemahoanghuy.repo.PermissionRepository;
import com.example.cinemahoanghuy.service.IPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PermissionService implements IPermissionService {

    @Autowired
    private PermissionRepository permissionRepository;
    @Override
    public Optional<Permission> findById(Long id) {
        return permissionRepository.findById(id);
    }

    @Override
    public Permission saveOrUpdate(Permission permission) {
        return permissionRepository.save(permission);
    }

    @Override
    public void delete(Permission permission) {
        permissionRepository.delete(permission);
    }

    @Override
    public void delete(Long id) {
        permissionRepository.deleteById(id);
    }
}
