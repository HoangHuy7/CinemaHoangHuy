package com.example.cinemahoanghuy.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@MappedSuperclass
@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class BaseEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CreatedDate
    private Date createDate = new Date(System.currentTimeMillis());

    private Long createBy;

    private boolean status = true;

    @LastModifiedBy
    private Date updateDate;
    private Long updateBy;

    public BaseEntity( Long createBy, Date updateDate, Long updateBy) {
        this.createBy = createBy;
        this.updateDate = updateDate;
        this.updateBy = updateBy;
    }
}
