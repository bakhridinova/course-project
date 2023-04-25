package com.epam.uni.repository;

import com.epam.uni.entity.Dish;
import com.epam.uni.filter.SearchFilter;

import java.util.List;

/**
 * repository for handling CRUD operations on dishes
 *
 * @author bakhridinova
 */

public interface DishRepository extends BaseRepository<Dish> {
    @Override
    List<Dish> findAll();

    @Override
    Dish findById(Long id);

    @Override
    List<Dish> findByCategory(Enum<?> category);

    @Override
    List<Dish> findByFilter(SearchFilter filter);
}
