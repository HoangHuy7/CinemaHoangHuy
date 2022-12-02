package com.example.cinemahoanghuy.api;

import com.example.cinemahoanghuy.dto.TBranchDTO;
import com.example.cinemahoanghuy.service.IBranchService;
import com.example.cinemahoanghuy.service.serviceImpl.BranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000/")
@RequestMapping("/api/v1/branch")
public class BranchController {
    @Autowired
    private IBranchService branchService;

    @GetMapping("/findAll")
    public ResponseEntity<List<TBranchDTO>> findAllBranch(){
        return ResponseEntity.ok().body(branchService.findALl());
    }

}
