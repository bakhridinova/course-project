package com.epam.uni.controller;

import com.epam.uni.dto.DishDto;
import com.epam.uni.format.DishFormatter;
import com.epam.uni.service.DishService;
import com.epam.uni.util.method.MethodDescription;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

import java.util.Scanner;

/**
 * controller for handling dish related inputs
 *
 * @author bakhridinova
 */

@Controller
@RequiredArgsConstructor
public class DishController extends BaseController<DishDto> {
    private final DishFormatter dishFormatter;
    private final DishService dishService;
    private final Scanner scanner;

    @MethodDescription(command = "fad",
            value = "find all dishes")
    public void findAll() {
        findAll(dishService, dishFormatter);
    }

    @MethodDescription(command = "fdbi",
            value = "find dish by id")
    public void findById() {
        findById(scanner, dishService, dishFormatter, DishDto.class);
    }

    @MethodDescription(command = "fdbc",
            value = "find dish by category")
    public void findByCategory() {
        findByCategory(scanner, dishService, dishFormatter, DishDto.class);
    }

    @MethodDescription(command = "fdbf",
            value = "find dish by filter")
    public void findByFilter() {
        findByFilter(scanner, dishService, dishFormatter, DishDto.class);
    }
}
