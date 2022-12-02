package com.example.cinemahoanghuy.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
public class TBillDTO {
    private Long id;

    private java.sql.Timestamp createDate;
    private Boolean status;
//    private TUserDTO user;
    private BigDecimal total;
    private Integer quantityTicket;
//    private List<TTicketDTO> tickets;


}
