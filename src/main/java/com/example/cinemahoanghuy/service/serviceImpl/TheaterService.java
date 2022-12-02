package com.example.cinemahoanghuy.service.serviceImpl;

import com.example.cinemahoanghuy.dto.TTheaterDTO;
import com.example.cinemahoanghuy.entity.Schedule;
import com.example.cinemahoanghuy.entity.Theater;
import com.example.cinemahoanghuy.repo.ScheduleRepository;
import com.example.cinemahoanghuy.repo.TheaterRepository;
import com.example.cinemahoanghuy.service.ITheaterService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class TheaterService implements ITheaterService {
    @PersistenceContext
    EntityManager em;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private TheaterRepository theaterRepository;
    @Autowired
    private ScheduleRepository scheduleRepository;


    @Override
    public List<TTheaterDTO> findAllTByBranchNameAndTheaterNameAndDateShow(String theaterName, LocalDate showDate,Long movieId,String branchName) {
        List<TTheaterDTO> tTheaterDTOS;

        switch (branchName){
            case "all":
                if (theaterName.equals("all")){
                    tTheaterDTOS = theaterRepository
                            .findAllTheaterByBranchNameAndTheaterNameAndDateShow(showDate,movieId)
                            .stream().map(theater -> modelMapper.map(theater,TTheaterDTO.class))
                            .collect(Collectors.toList());
                }
                else {
                    tTheaterDTOS=theaterRepository
                            .findAllTheaterByBranchNameAndTheaterNameAndDateShow(theaterName,showDate,movieId)
                            .stream().map(theater -> modelMapper.map(theater,TTheaterDTO.class))
                            .collect(Collectors.toList());
                }
                break;
            default:
                if (theaterName.equals("all")){
                    tTheaterDTOS = theaterRepository
                            .findAllTheaterByBranchNameAndTheaterNameAndDateShow(showDate,movieId,branchName)
                            .stream().map(theater -> modelMapper.map(theater,TTheaterDTO.class))
                            .collect(Collectors.toList());
                }
                else {
                    tTheaterDTOS=theaterRepository
                            .findAllTheaterByBranchNameAndTheaterNameAndDateShow(theaterName,showDate,movieId,branchName)
                            .stream().map(theater -> modelMapper.map(theater,TTheaterDTO.class))
                            .collect(Collectors.toList());
                }
                break;
        }


        return tTheaterDTOS;
    }
    @Override
    public List<TTheaterDTO> findAllTByBranchIdAndTheaterIdAndDateShow( LocalDate showDate,Long movieId,Long branchId,Long theaterId) {
        List<TTheaterDTO> tTheaterDTOS = new ArrayList<>();

        if (branchId == 0L) {
            if (theaterId == 0) {
                // findAllTheaterByBranchIdAndTheaterIdAndDateShow(showDate,movieId)
                tTheaterDTOS = theaterRepository
                        .findAllTheaterByBranchIdAndTheaterIdAndDateShowAndMovieId(showDate,movieId)
                        .stream().map(theater -> modelMapper.map(theater,TTheaterDTO.class))
                        .collect(Collectors.toList());

            } else {
                // findAllTheaterByBranchIdAndTheaterIdAndDateShow(showDate,movieId,theaterId)
                tTheaterDTOS = theaterRepository
                        .findAllTheaterByBranchIdAndTheaterIdAndDateShowAndMovieId(showDate,movieId,theaterId)
                        .stream().map(theater -> modelMapper.map(theater,TTheaterDTO.class))
                        .collect(Collectors.toList());
            }
        } else {
            if (theaterId == 0) {
                // findAllTheaterByBranchIdAndTheaterIdAndDateShow(movieId,showDate,branchId)
                tTheaterDTOS = theaterRepository
                        .findAllTheaterByBranchIdAndTheaterIdAndDateShowAndMovieId(movieId,showDate,branchId)
                        .stream().map(theater -> modelMapper.map(theater,TTheaterDTO.class))
                        .collect(Collectors.toList());

            } else {
                // findAllTheaterByBranchIdAndTheaterIdAndDateShow(showDate,movieId,theaterId,branchId)
                tTheaterDTOS = theaterRepository
                        .findAllTheaterByBranchIdAndTheaterIdAndDateShowAndMovieId(showDate,movieId,theaterId,branchId)
                        .stream().map(theater -> modelMapper.map(theater,TTheaterDTO.class))
                        .collect(Collectors.toList());
            }
        }


        return tTheaterDTOS;
    }

    @Override @Transactional
    public void addScheduleToTheater( String nameTheater,Long scheduleId) {
        Optional<Schedule> scheduleOptional = scheduleRepository.findById(scheduleId);
        Optional<Theater> theaterOptional = theaterRepository.findByName(nameTheater);
        if (scheduleOptional.isPresent() && theaterOptional.isPresent()){
            scheduleOptional.get().setTheater(theaterOptional.get());
        }
    }

    @Override
    public List<TTheaterDTO> findTheaterInBranchName(String branchName) {
        return theaterRepository
                .findByTheaterInBranchName(branchName)
                .stream()
                .map(theater -> modelMapper.map(theater,TTheaterDTO.class))
                .collect(Collectors.toList());
    }
    @Override
    public List<TTheaterDTO> findTheaterByBranchId(Long branchId){
        return theaterRepository
                .findTheaterByBranchId(branchId)
                .stream()
                .map(theater -> modelMapper.map(theater,TTheaterDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<TTheaterDTO> findALl() {
        return theaterRepository
                .findAll()
                .stream()
                .map(theater -> modelMapper.map(theater, TTheaterDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<TTheaterDTO> findById(Long id) {
        return Optional
                .ofNullable(
                        modelMapper.map(theaterRepository.findById(id), TTheaterDTO.class)
                );
    }

    @Override
    public TTheaterDTO save(TTheaterDTO tTheaterDTO) {

        return theaterRepository.save(modelMapper.map(tTheaterDTO, Theater.class)) != null ? tTheaterDTO : null;
    }

    @Override
    public void delete(TTheaterDTO tTheaterDTO) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public TTheaterDTO update(TTheaterDTO tTheaterDTO) {
        return null;
    }


}
