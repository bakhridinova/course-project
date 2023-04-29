package com.epam.uni.repository;

import com.epam.uni.entity.Suppliance;
import com.epam.uni.filter.SearchFilter;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

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
    Predicate<T> getPredicate(SearchFilter filter);
    default Map<String, Comparator<Suppliance>> getComparators() {
        return Map.of(
            "p", Comparator.comparing(Suppliance::getPrice),
            "l", Comparator.comparing(Suppliance::getLeftInStock)
    );}
}
