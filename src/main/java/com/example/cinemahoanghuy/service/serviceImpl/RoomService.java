package com.example.cinemahoanghuy.service.serviceImpl;

import com.example.cinemahoanghuy.dto.TRoomDTO;
import com.example.cinemahoanghuy.entity.Room;
import com.example.cinemahoanghuy.repo.RoomRepository;
import com.example.cinemahoanghuy.service.IRoomService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoomService implements IRoomService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private RoomRepository roomRepository;


    @Override
    public List<TRoomDTO> findALl() {
        return null;
    }

    @Override
    public TRoomDTO findSeatsInRoomByScheduleId(Long scheduleId) {
        Optional<Room> optionalRoom = roomRepository.findRoomHaveSeatScheduleId(scheduleId);
        TRoomDTO tRoomDTO = null;
        if (optionalRoom.isPresent()){
            tRoomDTO = modelMapper.map(optionalRoom.get(),TRoomDTO.class);
        }
        return tRoomDTO;
    }

    @Override
    public Optional<TRoomDTO> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public TRoomDTO save(TRoomDTO tRoomDTO) {
        return null;
    }

    @Override
    public void delete(TRoomDTO tRoomDTO) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public TRoomDTO update(TRoomDTO tRoomDTO) {
        return null;
    }


}
