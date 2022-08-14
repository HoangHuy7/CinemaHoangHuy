package com.example.cinemahoanghuy.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "t_bill")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Bill extends BaseEntity{

    @ManyToOne
    @JoinColumn(nullable = false,name = "user_id")
    private User user;
}
