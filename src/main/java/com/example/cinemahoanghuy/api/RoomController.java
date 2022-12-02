package com.example.cinemahoanghuy.api;

import com.example.cinemahoanghuy.dto.TRoomDTO;
import com.example.cinemahoanghuy.service.IRoomService;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1/room")
@RequiredArgsConstructor
public class RoomController {

    @Autowired
    private IRoomService roomService;

    @RequestMapping(value = "/{scheduleId}",method = RequestMethod.GET)
    public ResponseEntity<?> findSeatsInRoomByScheduleId(@NotNull  @PathVariable(name = "scheduleId") Long scheduleId2){
        TRoomDTO tRoomDTO =roomService.findSeatsInRoomByScheduleId(scheduleId2);
        if (tRoomDTO == null){
            Map<String,String> message = new HashMap<>();
            message.put("message","Don't find roomId = " + scheduleId2);
            return ResponseEntity.badRequest().body(message);
        }
        return ResponseEntity.ok().body(tRoomDTO);
    }
}
