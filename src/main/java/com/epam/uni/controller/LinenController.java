package com.epam.uni.controller;

import com.epam.uni.dto.LinenDto;
import com.epam.uni.entity.enumerator.LinenCategory;
import com.epam.uni.service.LinenService;
import com.epam.uni.util.formatter.LinenFormatter;
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
public class LinenController {
    private final LinenService linenService;
    private final Scanner scanner;

    @MethodDescription(command = "fal",
            value = "find all linens")
    public void findAll() {
        List<LinenDto> linens = linenService.findAll();
        System.out.println(LinenFormatter.header());
        System.out.println(LinenFormatter.format(linens));
    }

    @MethodDescription(command = "flbi",
            value = "find linen by id")
    public void findById() {
        System.out.println("please, enter id of linen you want to find");
        Long id = scanner.nextLong();
        LinenDto linen = linenService.findById(id);
        System.out.println(LinenFormatter.header());
        System.out.println(LinenFormatter.format(linen));
    }

    @MethodDescription(command = "flbc",
            value = "find linen by category")
    public void findByCategory() {
        System.out.println("please, enter category of linens you want to search for");
        String category = scanner.next();
        List<LinenDto> linens = linenService
                .findByCategory(LinenCategory.valueOf(category));
        System.out.println(LinenFormatter.header());
        System.out.println(LinenFormatter.format(linens));
    }
}
