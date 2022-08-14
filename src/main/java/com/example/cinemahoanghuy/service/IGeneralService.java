package com.example.cinemahoanghuy.service;

import java.util.Optional;

public interface IGeneralService<T> {

    Optional<T> findById(Long id);

    T saveOrUpdate(T t);

    void delete(T t);

    void delete(Long id);
}
