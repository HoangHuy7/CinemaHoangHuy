package com.example.cinemahoanghuy.dto;

import lombok.Data;

import java.util.Set;

@Data
public class TTheaterDTO {
    private Long id;
    private String address;
    private String image;
    private String imageUrl;
    private String name;
    private String shortName;
    private Set<TScheduleDTO> schedules;

}
