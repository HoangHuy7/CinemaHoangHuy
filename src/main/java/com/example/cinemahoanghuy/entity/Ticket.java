package com.example.cinemahoanghuy.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "t_Ticket")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Ticket extends BaseEntity{

    @Column(columnDefinition = "TEXT")
    private String QRCode;
    private String description;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "seat_id")
    private Seat seat;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "schedule_id")
    private Schedule schedule;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "bill_id")
    private Bill bill;

}
