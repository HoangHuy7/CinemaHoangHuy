package com.example.cinemahoanghuy.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "t_Branch")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Branch extends BaseEntity {
    private String address;
    private String name;
    private String phone;
    private String mapURL;

    @OneToMany(mappedBy = "branch",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Set<Theater> theaters;


//    @OneToMany(mappedBy = "branch")
//    @EqualsAndHashCode.Exclude
//    @ToString.Exclude
//    private Set<Schedule> schedules;

//    @OneToMany(mappedBy = "branch")
//    @EqualsAndHashCode.Exclude
//    @ToString.Exclude
//    private Set<Room> rooms;

}
