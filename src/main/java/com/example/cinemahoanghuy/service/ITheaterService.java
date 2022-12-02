package com.example.cinemahoanghuy.service;

import com.example.cinemahoanghuy.dto.TTheaterDTO;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface ITheaterService extends IGeneralService<TTheaterDTO>{
    void addScheduleToTheater(String nameTheater,Long scheduleId);

    List<TTheaterDTO> findTheaterInBranchName(String branchName);
    List<TTheaterDTO> findTheaterByBranchId(Long branchId);

    List<TTheaterDTO> findAllTByBranchNameAndTheaterNameAndDateShow(String theaterName, LocalDate showDate,Long movieId,String branchName);

    List<TTheaterDTO> findAllTByBranchIdAndTheaterIdAndDateShow( LocalDate showDate,Long movieId,Long branchId,Long theaterId);
}
