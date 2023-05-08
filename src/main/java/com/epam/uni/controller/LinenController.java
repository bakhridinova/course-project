package com.epam.uni.controller;

import com.epam.uni.dto.LinenDto;
import com.epam.uni.service.LinenService;
import com.epam.uni.util.annotation.MethodDescription;
import com.epam.uni.util.format.impl.LinenFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.Scanner;

/**
 * controller for handling dish related inputs
 *
 * @author bakhridinova
 */

@Controller
public class LinenController extends BaseController<LinenDto> {
    private final LinenFormatter linenFormatter;
    private final LinenService linenService;

    @Autowired
    private LinenController(Scanner scanner, LinenFormatter linenFormatter, LinenService linenService) {
        super(scanner);
        this.linenFormatter = linenFormatter;
        this.linenService = linenService;
    }

    @MethodDescription(command = "fal",
            value = "find all linens")
    public void findAll() {
        findAll(linenService, linenFormatter);
    }

    @MethodDescription(command = "flbi",
            value = "find linen by id")
    public void findById() {
        findById(linenService, linenFormatter, LinenDto.class);
    }

    @MethodDescription(command = "flbc",
            value = "find linen by category")
    public void findByCategory() {
        findByCategory(linenService, linenFormatter, LinenDto.class);
    }

    @MethodDescription(command = "flbf",
            value = "find linen by filter")
    public void findByFilter() {
        findByFilter(linenService, linenFormatter, LinenDto.class);
    }
}
