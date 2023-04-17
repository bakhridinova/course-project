package com.epam.uni.repository.impl;

import com.epam.uni.entity.Dish;
import com.epam.uni.repository.DishRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
 * repository for handling CRUD operations on dishes
 *
 * @author bakhridinova
 */

@Component
public class DishRepositoryImpl implements DishRepository {
    @Override
    public List<Dish> findAll() {
        return null;
    }

    @Override
    public Optional<Dish> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public List<Dish> findByCategory(Enum<?> category) {
        return null;
    }

    @Override
    public Dish create(Dish dish) {
        return null;
    }

    @Override
    public Dish update(Dish dish) {
        return null;
    }

    @Override
    public void delete(Dish dish) {

    }
}
