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
        System.out.print(DishFormatter.format(dishes));
        System.out.println(DishFormatter.footer());
    }

    @MethodDescription(command = "fdbi",
            value = "find dish by id")
    public void findById() {
        System.out.print("please, enter id of dish you want to search for: ");
        Long id = scanner.nextLong();
        DishDto dish = dishService.findById(id);
        System.out.println(DishFormatter.header());
        System.out.print(DishFormatter.format(dish));
        System.out.println(DishFormatter.footer());
    }

    @MethodDescription(command = "fdbc",
            value = "find dish by category")
    public void findByCategory() {
        System.out.print("please, enter category of dishes you want to search for: ");
        String category = scanner.next();
        List<DishDto> dishes = dishService
                .findByCategory(DishCategory.valueOf(category));
        System.out.println(DishFormatter.header());
        System.out.print(DishFormatter.format(dishes));
        System.out.println(DishFormatter.footer());
    }
}
