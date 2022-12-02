package com.example.cinemahoanghuy.repo;

import com.example.cinemahoanghuy.entity.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BillRepository extends JpaRepository<Bill, Long> {

    @Query(value = "select B from  Bill B  where  B.user.id = :userId")
    Optional<List<Bill> > findAllByUserId(@Param(value = "userId") Long userId);
}