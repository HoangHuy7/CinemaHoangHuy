package com.example.cinemahoanghuy.repo;

import com.example.cinemahoanghuy.entity.Theater;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public interface TheaterRepository extends JpaRepository<Theater, Long> {

    Optional<Theater> findByName(String name);

    @Query("select t from Theater t join Branch b on t.branch.id = b.id where b.name = ?1")
    List<Theater> findByTheaterInBranchName(String branchName);

    @Query("select t from Theater t join Branch b on t.branch.id = b.id where b.id = ?1")
    List<Theater> findTheaterByBranchId(Long branchId);





    @Query("select t from Theater t join FETCH Schedule s on t.id = s.theater.id where t.name = ?1 and s.showDate = ?2 and s.movies.id = ?3")
    Set<Theater> findAllTheaterByBranchNameAndTheaterNameAndDateShow(String theaterName, LocalDate showDate, Long movieId);

    @Query("select t from Theater t join FETCH Schedule s on t.id = s.theater.id where  s.showDate = ?1 and s.movies.id = ?2")
    Set<Theater> findAllTheaterByBranchNameAndTheaterNameAndDateShow( LocalDate showDate, Long movieId);
    @Query("select t from Theater t join FETCH Schedule s on t.id = s.theater.id where  s.showDate = ?1 and s.movies.id = ?2 and t.branch.name = ?3")
    Set<Theater> findAllTheaterByBranchNameAndTheaterNameAndDateShow( LocalDate showDate, Long movieId,String branchName);

    @Query("select t from Theater t join FETCH Schedule s on t.id = s.theater.id where t.name = ?1 and s.showDate = ?2 and s.movies.id = ?3 and t.branch.name = ?4")
    Set<Theater> findAllTheaterByBranchNameAndTheaterNameAndDateShow(String theaterName, LocalDate showDate, Long movieId,String branchName);


    // by id

    @Query("select t from Theater t join FETCH Schedule s on t.id = s.theater.id" +
            " where t.id = :theaterId and s.showDate = :showDate and s.movies.id = :movieId")
    Set<Theater> findAllTheaterByBranchIdAndTheaterIdAndDateShowAndMovieId
            (@Param("showDate") LocalDate showDate,@Param("movieId") Long movieId,@Param("theaterId") Long theaterId); // tim theo rap

    @Query("select t from Theater t join FETCH Schedule s on t.id = s.theater.id " +
            "where  s.showDate = :showDate and s.movies.id = :movieId")
    Set<Theater> findAllTheaterByBranchIdAndTheaterIdAndDateShowAndMovieId
            ( @Param("showDate") LocalDate showDate,@Param("movieId") Long movieId); // day la tim tat ca

    @Query("select t from Theater t join FETCH Schedule s on t.id = s.theater.id " +
            "where  s.showDate = :showDate and s.movies.id = :movieId and t.branch.id = :branchId")
    Set<Theater> findAllTheaterByBranchIdAndTheaterIdAndDateShowAndMovieId
            (@Param("movieId") Long movieId,@Param("showDate") LocalDate showDate,@Param("branchId") Long branchId); // tim tat ca theo chi nhanh

    @Query("select t from Theater t join FETCH Schedule s on t.id = s.theater.id " +
            "where t.id = :theaterId and s.showDate = :showDate and s.movies.id = :movieId and t.branch.id = :branchId")
    Set<Theater> findAllTheaterByBranchIdAndTheaterIdAndDateShowAndMovieId
            ( @Param("showDate") LocalDate showDate,@Param("movieId")Long movieId,@Param("theaterId") Long theaterId,@Param("branchId")Long branchId);
}