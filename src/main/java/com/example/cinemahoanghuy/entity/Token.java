package com.example.cinemahoanghuy.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id" )
    @ToString.Exclude

    private User user;


}
