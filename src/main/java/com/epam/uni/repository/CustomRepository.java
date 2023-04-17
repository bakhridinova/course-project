package com.epam.uni.repository;

import com.epam.uni.entity.Suppliance;

import java.util.List;
import java.util.Optional;

/**
 * custom suppliance repository
 *
 * @author bakhridinova
 */

public interface CustomRepository<T extends Suppliance> {
    List<T> findAll();
    Optional<T> findById(Long id);
    List<T> findByCategory(Enum<?> category);
    T create(T t);
    T update(T t);
    void  delete(T t);
}
