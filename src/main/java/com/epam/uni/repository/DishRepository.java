package com.epam.uni.repository;

import com.epam.uni.entity.Dish;
import com.epam.uni.filter.SearchFilter;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;

/**
 * repository for handling CRUD operations on dishes
 *
 * @author bakhridinova
 */

public interface DishRepository extends BaseRepository<Dish> {

    default Predicate<Dish> getPredicate(SearchFilter filter) {
        List<Predicate<Dish>> predicates = new LinkedList<>();
        if (!filter.category().equals("s".toUpperCase())) {
            predicates.add(dish -> dish.getCategory().name()
                    .equals(filter.category()));
        }

        if (!filter.material().equals("s".toUpperCase())) {
            predicates.add(dish -> dish.getMaterial().toString()
                    .equals(filter.material()));
        }

        if (!filter.description().equals("s")) {
            predicates.add(dish -> dish.getDescription()
                    .contains(filter.description()));
        }

        return predicates.stream().reduce(x -> true, Predicate::and);
    }
}
