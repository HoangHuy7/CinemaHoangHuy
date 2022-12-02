package com.example.cinemahoanghuy.service.serviceImpl;

import com.example.cinemahoanghuy.entity.Role;
import com.example.cinemahoanghuy.entity.User;
import com.example.cinemahoanghuy.repo.RoleRepository;
import com.example.cinemahoanghuy.repo.UserRepository;
import com.example.cinemahoanghuy.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.spel.ast.OpInc;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService {
    private final UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;

    public UserService(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public List<User> findALl() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public void delete(User user) {
        userRepository.delete(user);
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    @Transactional
    public User update(User userNew) {
        User userOld = userRepository.findByUsername(userNew.getUsername()).orElse(null);
        if (userOld != null) {
            userOld.setUpdateDate(new Date(System.currentTimeMillis()));
            userOld.setPassword(passwordEncoder.encode(userNew.getPassword()));
            userOld.setFullName(userNew.getFullName());
            userOld.setUpdateBy(userNew.getUpdateBy());
        }
        return userOld;
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    @Transactional
    public void addRoleToUser(String username, String roleName) {
        Optional<User> user = userRepository.findByUsername(username);
        Optional<Role> role = roleRepository.findByName(roleName);
        if (user.isPresent() && role.isPresent()) {
            user.get().getRoles().add(role.get());
        }


    }
}
