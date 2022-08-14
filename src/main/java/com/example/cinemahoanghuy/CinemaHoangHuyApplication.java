package com.example.cinemahoanghuy;

import com.example.cinemahoanghuy.entity.BaseEntity;
import com.example.cinemahoanghuy.entity.Permission;
import com.example.cinemahoanghuy.entity.Role;
import com.example.cinemahoanghuy.entity.User;
import com.example.cinemahoanghuy.service.IPermissionService;
import com.example.cinemahoanghuy.service.IRoleService;
import com.example.cinemahoanghuy.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
@RequiredArgsConstructor
public class CinemaHoangHuyApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(CinemaHoangHuyApplication.class, args);
    }


    @Autowired
    private IUserService userService;

    @Autowired
    private IRoleService roleService;

    @Autowired
    private IPermissionService permissionService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
//       User user = User.builder().fullName("huy").password(passwordEncoder.encode("1234")).username("huy").build();
//        Role role = Role.builder().name("ADMIN").build();
//        Permission permission = Permission.builder().name("CREATE").build();
//
//
//        System.out.println(userService.saveOrUpdate(user));
//        roleService.saveOrUpdate(role);
//        userService.addRoleToUser("huy","ADMIN");
//        permissionService.saveOrUpdate(permission);
//       roleService.addPermissionToRole("ADMIN","CREATE");
//
//        System.out.println(passwordEncoder.encode("1234"));
    }
}
