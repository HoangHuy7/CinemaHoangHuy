package com.example.cinemahoanghuy.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TBranchDTO {
    private Long id;
    private String address;
    private String mapurl;
    private String name;
    private String phone;


}
