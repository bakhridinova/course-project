package com.epam.uni.repository;

import com.epam.uni.entity.Suppliance;
import com.epam.uni.util.filter.SearchFilter;

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
    /**
     * retrieves all entities of corresponding type
     *
     * @return list of entities
     */
    List<T> findAll();

    /**
     * retrieves entity of corresponding type
     * with specified id
     *
     * @param id of entity
     * @return entity
     */
    T findById(Long id);

    /**
     * retrieves entities of corresponding type
     * with specified category
     *
     * @param category of entity
     * @return list of entities
     */
    List<T> findByCategory(Enum<?> category);

    /**
     * retrieves entities of corresponding type
     * with specified search parameters
     *
     * @param filter with search parameters
     * @return list of entities
     */
    List<T> findByFilter(SearchFilter filter);

    /**
     * retrieves predicate of corresponding type
     * based on parameters
     *
     * @param filter with search parameters
     * @return predicate
     */
    Predicate<T> getPredicate(SearchFilter filter);

    /**
     * retrieves comparators supported by suppliances
     *
     * @return map of comparators
     */
    default Map<String, Comparator<Suppliance>> getComparators() {
        return Map.of(
            "p", Comparator.comparing(Suppliance::getPrice),
            "l", Comparator.comparing(Suppliance::getLeftInStock)
    );}
}
