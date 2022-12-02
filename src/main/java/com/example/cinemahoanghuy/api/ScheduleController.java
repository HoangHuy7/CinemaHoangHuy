package com.example.cinemahoanghuy.api;


import com.example.cinemahoanghuy.dto.TScheduleDTO;
import com.example.cinemahoanghuy.entity.Schedule;
import com.example.cinemahoanghuy.service.IScheduleService;
import com.example.cinemahoanghuy.service.serviceImpl.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1/schedule")
@RestController
@CrossOrigin("*")
public class ScheduleController {
    @Autowired
    private IScheduleService scheduleService;

    @RequestMapping(value = "/findRoomInScheduleOfMovie", method = RequestMethod.GET)
    public TScheduleDTO findMovieAndRoomInSchedule(
            @RequestParam(name = "movieId") Long movieId
            , @RequestParam(name = "scheduleId") Long scheduleId
            , @RequestParam(name = "roomId") Long roomId) {

        return null;
    }

}
