package com.example.cinemahoanghuy;

import com.example.cinemahoanghuy.dto.TMoviesDTO;
import com.example.cinemahoanghuy.service.serviceImpl.MovieService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class MoviesServiceTest {



    @Autowired
    private MovieService movieService;

    @Test
    public void testFindAll(){
        List<TMoviesDTO> moviesDTOList = movieService.findALl();
        moviesDTOList.forEach(tMoviesDTO -> System.out.println(tMoviesDTO.getName()));
        assertTrue(moviesDTOList.size() > 0);

    }
}
