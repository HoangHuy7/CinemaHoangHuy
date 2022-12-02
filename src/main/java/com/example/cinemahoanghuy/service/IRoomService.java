package com.example.cinemahoanghuy.service;

import com.example.cinemahoanghuy.dto.TRoomDTO;

import java.util.List;

public interface IRoomService extends IGeneralService<TRoomDTO>{

    TRoomDTO findSeatsInRoomByScheduleId(Long scheduleId);
}
