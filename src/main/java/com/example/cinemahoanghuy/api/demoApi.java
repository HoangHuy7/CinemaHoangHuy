package com.example.cinemahoanghuy.api;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/v1/")
@RestController
public class demoApi {

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/shiba")
    public String test(){
        return "ban co quyen admin";
    }
    @GetMapping("/hello")
    public String hello(){
        return "ban k co gi";
    }
}
