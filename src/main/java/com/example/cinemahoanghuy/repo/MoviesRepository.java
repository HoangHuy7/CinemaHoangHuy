package com.example.cinemahoanghuy.repo;

import com.example.cinemahoanghuy.entity.Movies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MoviesRepository extends JpaRepository<Movies, Long> {

    @Query("select m from Movies m where m.name like %:filmName%")
    List<Movies> searchByFilmName(@Param("filmName") String filmName);
}