package com.epam.uni.controller;

import com.epam.uni.service.DishService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * controller for handling dish related inputs
 *
 * @author bakhridinova
 */

@Component
@RequiredArgsConstructor
public class DishController {
    private final DishService dishService;
}
