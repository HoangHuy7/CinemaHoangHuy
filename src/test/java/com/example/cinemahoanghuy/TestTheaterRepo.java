package com.example.cinemahoanghuy;

import com.example.cinemahoanghuy.dto.TTheaterDTO;
import com.example.cinemahoanghuy.entity.Theater;
import com.example.cinemahoanghuy.repo.TheaterRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@Slf4j
public class TestTheaterRepo {

    @Autowired
    private TheaterRepository theaterRepository;

    @Test
    public void testFindTheaterInBranch(){
        List<Theater> theaters = theaterRepository.findByTheaterInBranchName("HO CHI MINH");
        assertTrue(theaters.size() > 0);
    }

    @Test
    // findAll
    public void testFindTheatersdInBranch9(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String date = "20/07/2022";
        ModelMapper modelMapper = new ModelMapper();
        LocalDate localDate = LocalDate.parse(date, formatter);
        Set<Theater> theaters = theaterRepository
                .findAllTheaterByBranchIdAndTheaterIdAndDateShowAndMovieId(localDate,3L);
        Set<TTheaterDTO> tTheaterDTOS = theaters.stream().map(theater -> modelMapper.map(theater,TTheaterDTO.class)).collect(Collectors.toSet());
        assertTrue(theaters.size() > 0);
    }

    @Test
    public void testFindByTheater(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String date = "20/07/2022";
        ModelMapper modelMapper = new ModelMapper();
        LocalDate localDate = LocalDate.parse(date, formatter);
        Set<Theater> theaters = theaterRepository
                .findAllTheaterByBranchIdAndTheaterIdAndDateShowAndMovieId(localDate,3L,1L);
        Set<TTheaterDTO> tTheaterDTOS = theaters.stream().map(theater -> modelMapper.map(theater,TTheaterDTO.class)).collect(Collectors.toSet());
        assertTrue(theaters.size() > 0);
    }

    @Test
    public void testFindByBranch(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String date = "20/07/2022";
        ModelMapper modelMapper = new ModelMapper();
        LocalDate localDate = LocalDate.parse(date, formatter);
        Set<Theater> theaters = theaterRepository
                .findAllTheaterByBranchIdAndTheaterIdAndDateShowAndMovieId(3L,localDate,1L);
        Set<TTheaterDTO> tTheaterDTOS = theaters.stream().map(theater -> modelMapper.map(theater,TTheaterDTO.class)).collect(Collectors.toSet());
        log.warn(tTheaterDTOS.toString());
        assertTrue(theaters.size() > 0);
    }
    @Test
    public void testFindByBranchAndTheaer(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String date = "20/07/2022";
        ModelMapper modelMapper = new ModelMapper();
        LocalDate localDate = LocalDate.parse(date, formatter);
        Set<Theater> theaters = theaterRepository
                .findAllTheaterByBranchIdAndTheaterIdAndDateShowAndMovieId(localDate,3L,1L,1L);
        Set<TTheaterDTO> tTheaterDTOS = theaters.stream().map(theater -> modelMapper.map(theater,TTheaterDTO.class)).collect(Collectors.toSet());
        log.warn(tTheaterDTOS.toString());
        assertTrue(theaters.size() > 0);
    }


    @Test
    public void testFindTheatersdInBranch5(){
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String date = "20/07/2022";
        ModelMapper modelMapper = new ModelMapper();
        LocalDate localDate = LocalDate.parse(date, formatter);
        Set<Theater> theaters = theaterRepository.findAllTheaterByBranchNameAndTheaterNameAndDateShow("Viccom Trà Vinh",localDate,1L);
        Set<TTheaterDTO> tTheaterDTOS = theaters.stream().map(theater -> modelMapper.map(theater,TTheaterDTO.class)).collect(Collectors.toSet());
        assertTrue(theaters.size() > 0);
    }
    @Test @Transactional
    public void testFindTheaterInBranch4(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String date = "20/07/2022";
        ModelMapper modelMapper = new ModelMapper();
        LocalDate localDate = LocalDate.parse(date, formatter);
        Set<Theater> theaters = theaterRepository.findAllTheaterByBranchNameAndTheaterNameAndDateShow("Viccom Trà Vinh",localDate,1L);
        assertTrue(theaters.size() > 00);
    }


}
