package com.epam.uni.repository;

import com.epam.uni.config.TestConfig;
import com.epam.uni.entity.Linen;
import com.epam.uni.entity.enums.LinenCategory;
import com.epam.uni.entity.enums.LinenMaterial;
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
class LinenRepositoryTest {
    @Autowired
    private LinenRepository linenRepository;

    @Test
    void shouldReturnListWithInitialSize() {
        assertEquals(10, linenRepository.findAll().size());
    }

    @Test
    void shouldReturnEntityWithMatchingId() {
        IntStream.range(1, 11)
                .forEach(id -> {
                    Linen linen = linenRepository.findById((long) id);
                    assertEquals(id, linen.getId());
                });
    }

    @Test
    void shouldThrowExceptionIfEntityWithMatchingIdDoesNotExist() {
        assertThrows(CustomEntityNotFoundException.class,
                () -> linenRepository.findById(0L));
    }

    @Test
    void shouldReturnEntitiesWithMatchingCategory() {
        Arrays.stream(LinenCategory.values())
                .forEach(category -> {
                    List<Linen> linens = linenRepository.findByCategory(category);
                    linens.forEach(linen -> assertEquals(category, linen.getCategory()));
                });
    }

    @Test
    void shouldReturnEmptyListIfEntitiesWithMatchingCategoryDoNotExist() {
        assertTrue(linenRepository.findByCategory(LinenCategory.TEST).isEmpty());
    }

    @Test
    void shouldReturnListSortedByPriceAscending() {
        SearchFilter filter = new SearchFilter(
                "p", "s", "s", "s", "s");

        List<Linen> linens = linenRepository.findByFilter(filter);
        IntStream.range(1, linens.size())
                .mapToObj(i -> linens.get(i - 1).getPrice()
                        .compareTo(linens.get(i).getPrice()) < 0)
                .forEach(Assertions::assertTrue);
    }

    @Test
    void shouldReturnListSortedByPriceDescending() {
        SearchFilter filter = new SearchFilter(
                "p", "d", "s", "s", "s");

        List<Linen> linens = linenRepository.findByFilter(filter);
        IntStream.range(1, linens.size())
                .mapToObj(i -> linens.get(i - 1).getPrice()
                        .compareTo(linens.get(i).getPrice()) > 0)
                .forEach(Assertions::assertTrue);
    }

    @Test
    void shouldReturnListSortedByLeftInStockAscending() {
        SearchFilter filter = new SearchFilter(
                "l", "s", "s", "s", "s");

        List<Linen> linens = linenRepository.findByFilter(filter);
        IntStream.range(1, linens.size())
                .mapToObj(i -> linens.get(i - 1).getLeftInStock()
                        .compareTo(linens.get(i).getLeftInStock()) < 0)
                .forEach(Assertions::assertTrue);
    }

    @Test
    void shouldReturnListSortedByLeftInStockDescending() {
        SearchFilter filter = new SearchFilter(
                "l", "d", "s", "s", "s");

        List<Linen> linens = linenRepository.findByFilter(filter);
        IntStream.range(1, linens.size())
                .mapToObj(i -> linens.get(i - 1).getLeftInStock()
                        .compareTo(linens.get(i).getLeftInStock()) > 0)
                .forEach(Assertions::assertTrue);
    }

    @Test
    void shouldReturnListWithMatchingCategory() {
        Arrays.stream(LinenCategory.values())
                .forEach(category -> {
                    List<Linen> linens = linenRepository.findByFilter(new SearchFilter(
                            "s", "d", category.toString(), "s", "s"));
                    linens.forEach(linen -> assertEquals(category, linen.getCategory()));
                });
    }

    @Test
    void shouldReturnListWithMatchingMaterial() {
        Arrays.stream(LinenMaterial.values())
                .forEach(material -> {
                    List<Linen> linens = linenRepository.findByFilter(new SearchFilter(
                            "s", "d", "s", material.toString(), "s"));
                    linens.forEach(linen -> assertEquals(material, linen.getMaterial()));
                });
    }
}