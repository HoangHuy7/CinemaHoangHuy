package com.example.cinemahoanghuy.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "t_permission")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Permission extends BaseEntity {
    @Column(unique = true)
    private String name;

    @JsonIgnore
    @ManyToMany(mappedBy = "permissions",fetch = FetchType.EAGER)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Set<Role> roles;
}
