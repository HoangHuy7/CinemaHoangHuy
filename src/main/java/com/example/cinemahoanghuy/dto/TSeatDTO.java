package com.example.cinemahoanghuy.dto;

import lombok.Data;

@Data
public class TSeatDTO {
    private Long id;
    private Boolean status;
    private String position;
    private Long roomId;
}
