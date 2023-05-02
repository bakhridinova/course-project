package com.epam.uni.controller;

import com.epam.uni.dto.LinenDto;
import com.epam.uni.format.LinenFormatter;
import com.epam.uni.service.LinenService;
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
public class LinenController extends BaseController<LinenDto> {
    private final LinenFormatter linenFormatter;
    private final LinenService linenService;
    private final Scanner scanner;

    @MethodDescription(command = "fal",
            value = "find all linens")
    public void findAll() {
        findAll(linenService, linenFormatter);
    }

    @MethodDescription(command = "flbi",
            value = "find linen by id")
    public void findById() {
        findById(scanner, linenService, linenFormatter, LinenDto.class);
    }

    @MethodDescription(command = "flbc",
            value = "find linen by category")
    public void findByCategory() {
        findByCategory(scanner, linenService, linenFormatter, LinenDto.class);
    }

    @MethodDescription(command = "flbf",
            value = "find linen by filter")
    public void findByFilter() {
        findByFilter(scanner, linenService, linenFormatter, LinenDto.class);
    }
}
