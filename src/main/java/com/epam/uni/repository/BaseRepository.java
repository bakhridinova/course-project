package com.epam.uni.repository;

import com.epam.uni.entity.Suppliance;
import com.epam.uni.filter.SearchFilter;

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
    List<T> findByFilter(SearchFilter filter);
}
