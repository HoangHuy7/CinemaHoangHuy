package com.example.cinemahoanghuy.repo;

import com.example.cinemahoanghuy.entity.Token;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TokenRepository extends JpaRepository<Token, Long> {
    @Query(value = "from Token as T where T.user.id = ?1")
    Optional<Token> findByUserId(Long userId);

    @Query(value = "from Token  as T where  T.access_token = ?1")
    Token findByAccessToken(String Access_token);
}