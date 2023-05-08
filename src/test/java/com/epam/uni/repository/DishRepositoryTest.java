package com.epam.uni.repository;

import com.epam.uni.config.TestConfig;
import com.epam.uni.entity.Dish;
import com.epam.uni.entity.enums.DishCategory;
import com.epam.uni.entity.enums.DishMaterial;
import com.epam.uni.exception.CustomEntityNotFoundException;
import com.epam.uni.util.filter.SearchFilter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = TestConfig.class)
class DishRepositoryTest {
    @Autowired
    private DishRepository dishRepository;

    @Test
    void shouldReturnListWithInitialSize() {
        assertEquals(10, dishRepository.findAll().size());
    }

    @Test
    void shouldReturnEntityWithMatchingId() {
        IntStream.range(1, 11)
                .forEach(id -> {
                    Dish dish = dishRepository.findById((long) id);
                    assertEquals(id, dish.getId());
                });
    }

    @Test
    void shouldThrowExceptionIfEntityWithMatchingIdDoesNotExist() {
        assertThrows(CustomEntityNotFoundException.class,
                () -> dishRepository.findById(0L));
    }

    @Test
    void shouldReturnEntitiesWithMatchingCategory() {
        Arrays.stream(DishCategory.values())
                .forEach(category -> {
                    List<Dish> dishes = dishRepository.findByCategory(category);
                    dishes.forEach(dish -> assertEquals(category, dish.getCategory()));
                });
    }

    @Test
    void shouldReturnEmptyListIfEntitiesWithMatchingCategoryDoNotExist() {
        assertTrue(dishRepository.findByCategory(DishCategory.TEST).isEmpty());
    }

    @Test
    void shouldReturnListSortedByPriceAscending() {
        SearchFilter filter = new SearchFilter(
                "p", "s", "s", "s", "s");

        List<Dish> dishes = dishRepository.findByFilter(filter);
        IntStream.range(1, dishes.size())
                .mapToObj(i -> dishes.get(i - 1).getPrice()
                        .compareTo(dishes.get(i).getPrice()) < 0)
                .forEach(Assertions::assertTrue);
    }

    @Test
    void shouldReturnListSortedByPriceDescending() {
        SearchFilter filter = new SearchFilter(
                "p", "d", "s", "s", "s");

        List<Dish> dishes = dishRepository.findByFilter(filter);
        IntStream.range(1, dishes.size())
                .mapToObj(i -> dishes.get(i - 1).getPrice()
                        .compareTo(dishes.get(i).getPrice()) > 0)
                .forEach(Assertions::assertTrue);
    }

    @Test
    void shouldReturnListSortedByLeftInStockAscending() {
        SearchFilter filter = new SearchFilter(
                "l", "s", "s", "s", "s");

        List<Dish> dishes = dishRepository.findByFilter(filter);
        IntStream.range(1, dishes.size())
                .mapToObj(i -> dishes.get(i - 1).getLeftInStock()
                        .compareTo(dishes.get(i).getLeftInStock()) < 0)
                .forEach(Assertions::assertTrue);
    }

    @Test
    void shouldReturnListSortedByLeftInStockDescending() {
        SearchFilter filter = new SearchFilter(
                "l", "d", "s", "s", "s");

        List<Dish> dishes = dishRepository.findByFilter(filter);
        IntStream.range(1, dishes.size())
                .mapToObj(i -> dishes.get(i - 1).getLeftInStock()
                        .compareTo(dishes.get(i).getLeftInStock()) > 0)
                .forEach(Assertions::assertTrue);
    }

    @Test
    void shouldReturnListWithMatchingCategory() {
        Arrays.stream(DishCategory.values())
                .forEach(category -> {
                    List<Dish> dishes = dishRepository.findByFilter(new SearchFilter(
                            "s", "d", category.toString(), "s", "s"));
                    dishes.forEach(dish -> assertEquals(category, dish.getCategory()));
                });
    }

    @Test
    void shouldReturnListWithMatchingMaterial() {
        Arrays.stream(DishMaterial.values())
                .forEach(material -> {
                    List<Dish> dishes = dishRepository.findByFilter(new SearchFilter(
                            "s", "d", "s", material.toString(), "s"));
                    dishes.forEach(dish -> assertEquals(material, dish.getMaterial()));
                });
    }
}