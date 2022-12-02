package com.example.cinemahoanghuy.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "t_Schedule")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Schedule extends BaseEntity {
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate showDate;
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "HH:mm")
    private LocalTime timeStart;
    private BigDecimal price;



    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "theater_id")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Theater theater;

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)// 12/2 2022
    @JoinColumn(name = "movies_id")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Movies movies;


    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "room_id")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Room room;

    @OneToMany(mappedBy = "schedule", cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private List<Ticket> tickets;
}
