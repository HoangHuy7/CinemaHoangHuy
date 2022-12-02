package com.example.cinemahoanghuy;

import com.example.cinemahoanghuy.dto.TMoviesDTO;
import com.example.cinemahoanghuy.dto.TRoomDTO;
import com.example.cinemahoanghuy.entity.Room;
import com.example.cinemahoanghuy.repo.RoomRepository;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class RoomRepositoryTest {

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Test
    public void testFindRoomHaveSeatScheduleId(){

        Room room = roomRepository.findRoomHaveSeatScheduleId(6L).orElse(null);

        assertTrue(room != null);
    }

    @Test
    public void convertToDTO(){
        Optional<Room> optionalRoom = roomRepository.findRoomHaveSeatScheduleId(6L);
        TRoomDTO tRoomDTO = null;
        if (optionalRoom.isPresent()){
            tRoomDTO = modelMapper.map(optionalRoom.get(),TRoomDTO.class);
        }
            assertTrue(tRoomDTO != null);
    }
}
