package com.example.cinemahoanghuy.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TTicketDTO {

    private String qrcode;
    private String description;
    private TSeatDTO seat;
    private TScheduleDTOForBill schedule ;
}
