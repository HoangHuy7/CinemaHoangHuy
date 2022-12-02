package com.example.cinemahoanghuy.dto;

import com.example.cinemahoanghuy.entity.Seat;
import lombok.Data;

import java.util.List;

@Data
public class TRoomDTO {
    private Long id;
    private Boolean status;
    private Long capacity;
    private String image;
    private int columnSeat;
    private String name;
    private Integer totalSeat;
    private List<TSeatDTO> seats;
}
