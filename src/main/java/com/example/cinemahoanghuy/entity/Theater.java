package com.example.cinemahoanghuy.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "t_Theater")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Theater extends BaseEntity{
    private String name;
    private String shortName;
    private String address;
    private String imageUrl;
    private String image;

    @OneToMany(mappedBy = "theater",fetch = FetchType.EAGER)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Set<Schedule> schedules;

    @OneToMany(mappedBy = "theater",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Set<Room> rooms;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "branch_id")
    private Branch branch;
}
