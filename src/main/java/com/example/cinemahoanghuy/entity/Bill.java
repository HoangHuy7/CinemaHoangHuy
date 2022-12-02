package com.example.cinemahoanghuy.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "t_Bill")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Bill extends BaseEntity{

    @ManyToOne(cascade = CascadeType.MERGE,fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;
    @Column(columnDefinition = "DECIMAL(18,0)")
    private BigDecimal total;
    private Integer quantityTicket;
    @OneToMany(mappedBy = "bill", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Ticket> tickets;
}
