package com.example.cinemahoanghuy.service.serviceImpl;

import com.example.cinemahoanghuy.dto.TScheduleDTO;
import com.example.cinemahoanghuy.entity.Schedule;
import com.example.cinemahoanghuy.repo.ScheduleRepository;
import com.example.cinemahoanghuy.service.IScheduleService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ScheduleService implements IScheduleService {

    @Autowired
    private ScheduleRepository scheduleRepository;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public List<TScheduleDTO> findALl() {
        return scheduleRepository.findAll().stream().map(schedule -> modelMapper.map(schedule,TScheduleDTO.class)).collect(Collectors.toList());
    }

    @Override
    public Optional<TScheduleDTO> findById(Long id) {
        return Optional.ofNullable(modelMapper.map(scheduleRepository.findById(id),TScheduleDTO.class));
    }

    @Override
    public TScheduleDTO save(TScheduleDTO tScheduleDTO) {
        Schedule schedule = scheduleRepository.save(modelMapper.map(tScheduleDTO,Schedule.class));
        return schedule != null?tScheduleDTO: null;
    }

    @Override
    public void delete(TScheduleDTO tScheduleDTO) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public TScheduleDTO update(TScheduleDTO tScheduleDTO) {
        return null;
    }

    @Override
    public List<TScheduleDTO> findAllByShowDateAndMovieName(LocalDate showDate, String movieName) {

        return scheduleRepository
                .findAllByShowDateAndTheaterName(showDate, movieName)
                .map(scheduleList -> scheduleList
                        .stream()
                        .map(schedule -> modelMapper.map(schedule, TScheduleDTO.class))
                        .collect(Collectors.toList())).orElse(null);
    }

    @Override
    public TScheduleDTO findMovieAndRoomInSchedule(Long movieId, Long scheduleId, Long roomId) {




        return null;
    }
}
