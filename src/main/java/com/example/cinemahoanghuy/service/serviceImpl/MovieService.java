package com.example.cinemahoanghuy.service.serviceImpl;

import com.example.cinemahoanghuy.dto.TMoviesDTO;
import com.example.cinemahoanghuy.entity.Movies;
import com.example.cinemahoanghuy.repo.MoviesRepository;
import com.example.cinemahoanghuy.service.IMovieService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MovieService implements IMovieService {

    @Autowired
    private MoviesRepository moviesRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<TMoviesDTO> findALl() {
        return moviesRepository
                .findAll()
                .stream()
                .map(m -> modelMapper.map(m, TMoviesDTO.class))
                .collect(Collectors.toList());
    }
    @Override
    public List<TMoviesDTO> searchByFilmName(String filmName) {
        return moviesRepository
                .searchByFilmName(filmName)
                .stream()
                .map(movies -> modelMapper.map(movies,TMoviesDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<TMoviesDTO> findById(Long id) {
        return Optional.ofNullable(modelMapper.map(moviesRepository.findById(id),TMoviesDTO.class));
    }

    @Override
    public TMoviesDTO save(TMoviesDTO tMoviesDTO) {
        moviesRepository.save(modelMapper.map(tMoviesDTO, Movies.class));
        return tMoviesDTO;
    }

    @Override
    public void delete(TMoviesDTO tMoviesDTO) {

    }

    @Override
    public void delete(Long id) {
        moviesRepository.deleteById(id);
    }

    @Override
    public TMoviesDTO update(TMoviesDTO tMoviesDTO) {
        moviesRepository.save(modelMapper.map(tMoviesDTO, Movies.class));
        return tMoviesDTO ;
    }


}
