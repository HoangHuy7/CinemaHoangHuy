package com.example.cinemahoanghuy.service;

import com.example.cinemahoanghuy.dto.TMoviesDTO;

import java.util.List;

public interface IMovieService extends IGeneralService<TMoviesDTO>{
    List<TMoviesDTO> searchByFilmName(String filmName);
}
