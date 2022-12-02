package com.example.cinemahoanghuy.dto;

import lombok.Data;

import java.util.Date;

@Data
public class TMoviesDTO {
    private Long id;
    private String name;
    private Date premiere;
    private String imageURL;
    private String trailerURL;
    private String description;
}
