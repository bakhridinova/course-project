package com.epam.uni.controller;

import com.epam.uni.facade.impl.LinenFacade;
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
public class LinenController {
    private final LinenFacade linenFacade;

    @MethodDescription(command = "fal",
            value = "find all linens")
    public void findAll() {
       linenFacade.findAll();
    }

    @MethodDescription(command = "flbi",
            value = "find linen by id")
    public void findById() {
       linenFacade.findById();
    }

    @MethodDescription(command = "flbc",
            value = "find linen by category")
    public void findByCategory() {
        linenFacade.findByCategory();
    }

    @MethodDescription(command = "flbf",
            value = "find linen by filter")
    public void findByFilter() {
        linenFacade.findByFilter();
    }
}
