package com.example.cinemahoanghuy.service;

import com.example.cinemahoanghuy.dto.TBranchDTO;


public interface IBranchService extends IGeneralService<TBranchDTO>{
    void addTheaterToBranch(String nameTheater,String nameBranch);
}
