package com.example.cinemahoanghuy.entity;

import lombok.*;
import org.springframework.context.annotation.Lazy;

import javax.persistence.*;

@Entity
@Table(name = "t_token")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Token extends BaseEntity{

    private String access_token;
    private String refresh_token;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id" )
    @Lazy
    @ToString.Exclude
    private User user;


}
