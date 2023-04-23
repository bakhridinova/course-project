package com.epam.uni.controller;

import com.epam.uni.dto.DishDto;
import com.epam.uni.entity.enumerator.DishCategory;
import com.epam.uni.service.DishService;
import com.epam.uni.util.formatter.DishFormatter;
import com.epam.uni.util.method.MethodDescription;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Scanner;

/**
 * controller for handling dish related inputs
 *
 * @author bakhridinova
 */

@Controller
@RequiredArgsConstructor
public class DishController {
    private final DishService dishService;
    private final Scanner scanner;

    @MethodDescription(command = "fad",
            value = "find all dishes")
    public void findAll() {
        List<DishDto> dishes = dishService.findAll();
        System.out.println(DishFormatter.header());
        System.out.println(DishFormatter.format(dishes));
    }

    @MethodDescription(command = "fdbi",
            value = "find dish by id")
    public void findById(Long id) {
        DishDto dish = dishService.findById(id);
        System.out.println(DishFormatter.header());
        System.out.println(DishFormatter.format(dish));
    }

    @MethodDescription(command = "fdbc",
            value = "find dish by category")
    public void findByCategory(String category) {
        List<DishDto> dishes = dishService.findByCategory(DishCategory.TEST);
        System.out.println(DishFormatter.header());
        System.out.println(DishFormatter.format(dishes));
    }

    @MethodDescription(command = "cd",
            value = "create dish")
    public void create(DishDto dish) {
        dishService.create(dish);
    }

    @MethodDescription(command = "ud",
            value = "update dish")
    public void update(DishDto dishDto) {
        DishDto dish = dishService.update(dishDto);
        System.out.println(DishFormatter.header());
        System.out.println(DishFormatter.format(dish));
    }

    @MethodDescription(command = "dd",
            value = "delete dish")
    public void delete(Long id) {
        dishService.delete(id);
    }
}
