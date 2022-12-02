package com.example.cinemahoanghuy.entity;

import lombok.*;

import javax.persistence.*;


@Entity
@Table(name = "t_Seat")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Seat extends BaseEntity {

    private String position;
    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name = "room_id")
    @ToString.Exclude
    private Room room;
    private Long scheduleId;



}
