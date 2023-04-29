package com.epam.uni.repository.impl;

import com.epam.uni.entity.Dish;
import com.epam.uni.entity.Suppliance;
import com.epam.uni.exception.CustomEntityNotFoundException;
import com.epam.uni.filter.SearchFilter;
import com.epam.uni.repository.DishRepository;
import com.opencsv.bean.CsvToBeanBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Repository;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;

@Repository
@RequiredArgsConstructor
public class DishRepositoryImpl implements DishRepository {
    private final ObjectProvider<CsvToBeanBuilder<Dish>> dishBeanBuilderProvider;

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

    @Override
    public List<Dish> findByFilter(SearchFilter filter) {
        Comparator<Suppliance> comparator = getComparators()
                .getOrDefault(filter.sortType(), Comparator.comparing(Suppliance::getId));
        if (filter.isDescending()) {
            comparator = comparator.reversed();
        }
        return getParsedDishes().stream()
                .filter(getPredicate(filter))
                .sorted(comparator)
                .toList();
    }
}
