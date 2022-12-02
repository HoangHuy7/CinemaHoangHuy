package com.example.cinemahoanghuy.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "t_Room")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Room extends BaseEntity {
    private String name;
    private String image;
    private int totalSeat;
    private int columnSeat;
    private Long capacity;

    @OneToMany(mappedBy = "room", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Seat> seats;

    @OneToMany(mappedBy = "room", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @ToString.Exclude
    private Set<Schedule> schedules;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "theater_id")
    private Theater theater;

//    @ManyToOne
//    @JoinColumn(name = "branch_id")
//    private Branch branch;
}
