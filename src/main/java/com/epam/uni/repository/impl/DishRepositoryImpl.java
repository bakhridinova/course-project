package com.epam.uni.repository.impl;

import com.epam.uni.entity.Dish;
import com.epam.uni.exception.CustomEntityNotFoundException;
import com.epam.uni.repository.DishRepository;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.StatefulBeanToCsv;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;

@Repository
@RequiredArgsConstructor
public class DishRepositoryImpl implements DishRepository {
    private final ObjectProvider<CsvToBeanBuilder<Dish>> dishBeanBuilderProvider;
    private final ObjectProvider<StatefulBeanToCsv<Dish>> dishBeanWriterProvider;

    private List<Dish> getParsedDishes() {
        return Objects.requireNonNull(dishBeanBuilderProvider.getIfAvailable())
                .withType(Dish.class).build().parse();
    }

    @Override
    public List<Dish> findAll() {
        return getParsedDishes();
    }

    @Override
    public Dish findById(Long id) {
        return getParsedDishes().stream()
                .filter(dish -> dish.getId().equals(id)).findAny()
                .orElseThrow(() -> new CustomEntityNotFoundException("failed to find dish with id " + id));
    }

    @Override
    public List<Dish> findByCategory(Enum<?> category) {
        return getParsedDishes().stream()
                .filter(dish -> dish.getCategory().equals(category)).toList();
    }
}
