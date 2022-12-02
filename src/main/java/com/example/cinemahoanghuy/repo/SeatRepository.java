package com.example.cinemahoanghuy.repo;

import com.example.cinemahoanghuy.entity.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SeatRepository extends JpaRepository<Seat, Long> {
    @Query(value = "select s from  Seat s " +
            "where s.scheduleId = :scheduleId and s.room.id = :roomId" +
            " and s.position in(:positions) ")
    Optional<List<Seat>> findAllByScheduleIdAndRoomId(@Param("scheduleId") Long scheduleId, @Param("roomId") Long roomId,
                                                      @Param("positions") List<String> positions);
}