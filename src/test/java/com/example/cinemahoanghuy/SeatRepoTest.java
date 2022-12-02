package com.example.cinemahoanghuy;

import com.example.cinemahoanghuy.entity.Seat;
import com.example.cinemahoanghuy.repo.SeatRepository;
import com.example.cinemahoanghuy.service.serviceImpl.BillService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class SeatRepoTest {

    @Autowired
    SeatRepository seatRepository;

    @Autowired
    BillService billService;

    @Test
    public void test(){
//
//        Optional<List<Seat>> allByScheduleIdAndRoomId = seatRepository.findAllByScheduleIdAndRoomId(6L, 1L);
//        assertTrue(allByScheduleIdAndRoomId.isPresent());
    }
    @Test
    public void testBill(){
//        billService.createBill(5L,1L,6L,new ArrayList<>(Arrays.asList("20")));
    }
}
