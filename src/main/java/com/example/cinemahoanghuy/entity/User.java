package com.example.cinemahoanghuy.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "t_user")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User extends BaseEntity{

    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String fullName;

    @ManyToMany(fetch = FetchType.EAGER,cascade=CascadeType.ALL)
    @JoinTable(name = "users_roles",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id")})
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<Role> roles;



    public User(Date createDate, Long createBy, Date updateDate, Long updateBy, String username, String password, String fullName) {
        super(createDate, createBy, updateDate, updateBy);
        this.username = username;
        this.password = password;
        this.fullName = fullName;
    }
}

