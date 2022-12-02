package com.example.cinemahoanghuy.repo;

import com.example.cinemahoanghuy.entity.Room;
import org.hibernate.annotations.ParamDef;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {


    @Query("select r from Room r join Seat s on r.id = s.room.id where s.scheduleId = :scheduleId")
    Optional<Room> findRoomHaveSeatScheduleId(@Param(value = "scheduleId") Long scheduleId);
}