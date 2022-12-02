package com.example.cinemahoanghuy.api;

import com.example.cinemahoanghuy.entity.User;
import com.example.cinemahoanghuy.service.IUserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/v1/user")
@Slf4j
@RequiredArgsConstructor
public class UserController {

    private String jwtSecret = "huydeptraivodich";

    @Value("${cinemaHuy.app.jwtSecret}")
    private String test;

    private final IUserService userService;



    @GetMapping("/findAll")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<List<User>> findAll(){
        return ResponseEntity.ok().body(userService.findALl());
    }

    @GetMapping("/find/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<User> findOne(@PathVariable Long id){
        User user = userService.findById(id).orElse(null);
        return user!=null?ResponseEntity.ok().body(user):ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{user_id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public void delete(@PathVariable Long user_id) {
        userService.delete(user_id);
    }

    @PutMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<?> update(@RequestBody User user){
        User userUpdate = userService.update(user);
        Map<String,Object> responseResult = new HashMap<>();

        if (userUpdate != null){
            responseResult.put("username:",userUpdate.getUsername());
            responseResult.put("fullName:",userUpdate.getFullName());
            responseResult.put("updateDate:",userUpdate.getUpdateDate());
            return ResponseEntity.ok().body(responseResult);
        }else return ResponseEntity.badRequest().body("Ko co user nay de update");

    }

}
