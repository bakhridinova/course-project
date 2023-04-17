package com.epam.uni.repository;

import com.epam.uni.entity.Dish;

import java.util.List;
import java.util.Optional;

/**
 * repository for handling CRUD operations on dishes
 *
 * @author bakhridinova
 */

public interface DishRepository extends CustomRepository<Dish> {
    @Override
    List<Dish> findAll();

    @Override
    Optional<Dish> findById(Long id);

    @Override
    List<Dish> findByCategory(Enum<?> category);

    @Override
    Dish create(Dish dish);

    @Override
    Dish update(Dish dish);

    @Override
    void delete(Dish dish);
}
