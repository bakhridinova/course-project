package com.epam.uni.repository;

import com.epam.uni.entity.Suppliance;

import java.util.List;

/**
 * custom suppliance repository
 *
 * @author bakhridinova
 */

public interface BaseRepository<T extends Suppliance> {
    List<T> findAll();
    T findById(Long id);
    List<T> findByCategory(Enum<?> category);
    T create(T t);
    T update(T t);
    void  delete(T t);
}
