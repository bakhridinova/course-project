package com.epam.uni.controller;

import com.epam.uni.service.DishService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

/**
 * controller for handling dish related inputs
 *
 * @author bakhridinova
 */

@Controller
@RequiredArgsConstructor
public class DishController {
    private final DishService dishService;
}
