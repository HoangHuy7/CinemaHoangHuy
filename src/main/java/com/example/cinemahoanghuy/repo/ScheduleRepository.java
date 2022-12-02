package com.example.cinemahoanghuy.repo;

import com.example.cinemahoanghuy.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Long> {

    @Query("select s from Schedule s join Movies m on s.movies.id = m.id where s.showDate = ?1 and m.name = ?2")
    Optional<List<Schedule>> findAllByShowDateAndTheaterName(LocalDate date, String movieName);


    @Query("SELECT S FROM Schedule S join Movies M on S.movies.id = M.id join Room R on  S.room.id = R.id")
    Optional<Schedule> findByIdAndMoviesIdAndRoomId();

}