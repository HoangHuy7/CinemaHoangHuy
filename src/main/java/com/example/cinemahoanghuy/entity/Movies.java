package com.example.cinemahoanghuy.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "t_Movies")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Movies extends BaseEntity{
    private String name;
    private Date premiere;
    private String imageURL;
    private String trailerURL;
    private String description;

    @OneToMany(mappedBy = "movies")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Set<Schedule> schedules;
}
