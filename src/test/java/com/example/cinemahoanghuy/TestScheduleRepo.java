package com.example.cinemahoanghuy;

import com.example.cinemahoanghuy.entity.Schedule;
import com.example.cinemahoanghuy.repo.ScheduleRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;

@SpringBootTest
public class TestScheduleRepo {

    @Autowired
    private ScheduleRepository scheduleRepository;

    @Autowired
    private SimpleDateFormat simpleDateFormat;
    @Test
    public void testfindAllByShowDateAndTheaterName(){
//        try {
////            Optional<List<Schedule>> schedules = scheduleRepository.findAllByShowDateAndTheaterName(simpleDateFormat.parse("20/07/2022 00:00"),"NGƯỜI NHỆN KHÔNG CÒN NHÀ");
////
////            Assertions.assertTrue(schedules.isPresent());
//        } catch (ParseException e) {
//            throw new RuntimeException(e);
//        }
    }
}
