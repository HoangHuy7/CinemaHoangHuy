package com.example.cinemahoanghuy.dto;

import com.example.cinemahoanghuy.entity.Movies;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class TScheduleDTO {
    private Long id;
    private Boolean status;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate showDate;
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "HH:mm")
    private LocalTime timeStart;
    private BigDecimal price;
    private Long moviesId;
    private Long roomId;
    private TMoviesDTO tMoviesDTO;
    private TRoomDTO room;


}
