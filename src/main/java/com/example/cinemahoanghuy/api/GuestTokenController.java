package com.example.cinemahoanghuy.api;

import com.example.cinemahoanghuy.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;

@RestController
public class GuestTokenController {

    @Autowired
    private JwtUtil jwtUtil;

    @GetMapping("/api/guest")
    public ResponseEntity<String> getGuestToken(){
        return ResponseEntity.ok().body(jwtUtil.createAccessToken("GUEST","HUYCINEMA",new ArrayList<>(Arrays.asList("GUEST"))));
    }
}
