package com.epam.uni.facade.impl;

import com.epam.uni.dto.DishDto;
import com.epam.uni.entity.enums.DishCategory;
import com.epam.uni.entity.enums.DishMaterial;
import com.epam.uni.facade.BaseFacade;
import com.epam.uni.filter.SearchFilter;
import com.epam.uni.service.DishService;
import com.epam.uni.util.formatter.DishFormatter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;

@Component
@RequiredArgsConstructor
public class DishFacade implements BaseFacade<DishDto> {
    private final DishService dishService;
    private final Scanner scanner;

    @Override
    public void findAll() {
        List<DishDto> dishes = dishService.findAll();
        System.out.println(DishFormatter.header());
        System.out.print(DishFormatter.format(dishes));
        System.out.println(DishFormatter.footer());
    }

    @Override
    public void findById() {
        System.out.print("please, enter id of dish you want to search for: ");
        Long id = scanner.nextLong();
        DishDto dish = dishService.findById(id);
        System.out.println(DishFormatter.header());
        System.out.print(DishFormatter.format(dish));
        System.out.println(DishFormatter.footer());
    }

    @Override
    public void findByCategory() {
        String category = getCategory(scanner, DishDto.class, DishCategory.values());
        List<DishDto> dishes = dishService
                .findByCategory(DishCategory.valueOf(category));
        System.out.println(DishFormatter.header());
        System.out.print(DishFormatter.format(dishes));
        System.out.println(DishFormatter.footer());
    }

    @Override
    public void findByFilter() {
        String sortType = getSortType(scanner, DishDto.class);
        String sortOrder = getSortOrder(scanner, DishDto.class);
        String category = getCategory(scanner, DishDto.class, DishCategory.values());
        String material = getMaterial(scanner, DishDto.class, DishMaterial.values());
        String description = getDescription(scanner, DishDto.class);
        SearchFilter searchFilter = new SearchFilter(sortType, sortOrder, category, material, description);
        List<DishDto> dishes = dishService.findByFilter(searchFilter);
        System.out.println(DishFormatter.header());
        System.out.print(DishFormatter.format(dishes));
        System.out.println(DishFormatter.footer());
    }
}
