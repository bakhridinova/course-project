package com.epam.uni.controller;

import com.epam.uni.dto.DishDto;
import com.epam.uni.service.DishService;
import com.epam.uni.util.annotation.MethodDescription;
import com.epam.uni.util.format.impl.DishFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.Scanner;

/**
 * controller for handling dish related inputs
 *
 * @author bakhridinova
 */

@Controller
public class DishController extends BaseController<DishDto> {
    private final DishFormatter dishFormatter;
    private final DishService dishService;

    @Autowired
    private DishController(Scanner scanner, DishFormatter dishFormatter, DishService dishService) {
        super(scanner);
        this.dishFormatter = dishFormatter;
        this.dishService = dishService;
    }

    @MethodDescription(command = "fad",
            value = "find all dishes")
    public void findAll() {
        findAll(dishService, dishFormatter);
    }

    @MethodDescription(command = "fdbi",
            value = "find dish by id")
    public void findById() {
        findById(dishService, dishFormatter, DishDto.class);
    }

    @MethodDescription(command = "fdbc",
            value = "find dish by category")
    public void findByCategory() {
        findByCategory(dishService, dishFormatter, DishDto.class);
    }

    @MethodDescription(command = "fdbf",
            value = "find dish by filter")
    public void findByFilter() {
        findByFilter(dishService, dishFormatter, DishDto.class);
    }
}
