package com.example.cinemahoanghuy.api;

import com.example.cinemahoanghuy.dto.TMoviesDTO;
import com.example.cinemahoanghuy.entity.Movies;
import com.example.cinemahoanghuy.service.IMovieService;
import com.example.cinemahoanghuy.service.serviceImpl.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/movies")
@CrossOrigin("*")
public class MoviesController {

    @Autowired
    private IMovieService movieService;

    @GetMapping
    public ResponseEntity<List<TMoviesDTO>> findAll(){
        return ResponseEntity.ok().body(movieService.findALl());
    }

    @GetMapping("/{moviesName}")
    public ResponseEntity<List<TMoviesDTO>> searchFilmByKeyword(@PathVariable String moviesName){
        return ResponseEntity.ok().body(movieService.searchByFilmName(moviesName));
    }
    @GetMapping("/findOne/{movieId}")
    public ResponseEntity<TMoviesDTO> findOne(@PathVariable Long movieId){
        return ResponseEntity.ok().body(movieService.findById(movieId).orElse(null));
    }


}
