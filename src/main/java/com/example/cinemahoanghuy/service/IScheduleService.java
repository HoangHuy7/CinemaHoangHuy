package com.example.cinemahoanghuy.service;

import com.example.cinemahoanghuy.dto.TScheduleDTO;
import com.example.cinemahoanghuy.entity.Schedule;

import java.time.LocalDate;
import java.util.List;

public interface IScheduleService extends IGeneralService<TScheduleDTO>{
    List<TScheduleDTO> findAllByShowDateAndMovieName(LocalDate showDate, String movieName);
    TScheduleDTO findMovieAndRoomInSchedule(Long movieId, Long scheduleId,Long roomId);
}
