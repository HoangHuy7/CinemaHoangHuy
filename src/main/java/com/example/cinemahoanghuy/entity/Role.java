package com.example.cinemahoanghuy.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "t_role")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Role extends BaseEntity{
  @Column(unique = true)
  private String name;

  @JsonIgnore
  @ManyToMany(mappedBy = "roles",fetch = FetchType.EAGER)
  @EqualsAndHashCode.Exclude
  @ToString.Exclude
  private Set<User> users;




  @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
  @EqualsAndHashCode.Exclude
  @ToString.Exclude
  private Set<Permission> permissions;

}
