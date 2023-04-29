package com.epam.uni.controller;

import com.epam.uni.facade.impl.DishFacade;
import com.epam.uni.util.method.MethodDescription;
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
    private final DishFacade dishFacade;

    @MethodDescription(command = "fad",
            value = "find all dishes")
    public void findAll() {
        dishFacade.findAll();
    }

    @MethodDescription(command = "fdbi",
            value = "find dish by id")
    public void findById() {
        dishFacade.findById();
    }

    @MethodDescription(command = "fdbc",
            value = "find dish by category")
    public void findByCategory() {
       dishFacade.findByCategory();
    }

    @MethodDescription(command = "fdbf",
            value = "find dish by filter")
    public void findByFilter() {
        dishFacade.findByFilter();
    }
}
