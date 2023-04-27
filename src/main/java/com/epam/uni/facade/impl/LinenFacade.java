package com.epam.uni.facade.impl;

import com.epam.uni.dto.LinenDto;
import com.epam.uni.entity.enums.LinenCategory;
import com.epam.uni.facade.BaseFacade;
import com.epam.uni.service.LinenService;
import com.epam.uni.util.formatter.LinenFormatter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;

@Component
@RequiredArgsConstructor
public class LinenFacade implements BaseFacade<LinenDto> {
    private final LinenService linenService;
    private final Scanner scanner;

    @Override
    public void findAll() {
        List<LinenDto> linens = linenService.findAll();
        System.out.println(LinenFormatter.header());
        System.out.print(LinenFormatter.format(linens));
        System.out.println(LinenFormatter.footer());
    }

    @Override
    public void findById() {
        System.out.print("please, enter id of linen you want to search for: ");
        Long id = scanner.nextLong();
        LinenDto linen = linenService.findById(id);
        System.out.println(LinenFormatter.header());
        System.out.print(LinenFormatter.format(linen));
        System.out.println(LinenFormatter.footer());
    }

    @Override
    public void findByCategory() {
        System.out.print("please, enter category of linens you want to search for: ");
        String category = scanner.next();
        List<LinenDto> linens = linenService
                .findByCategory(LinenCategory.valueOf(category));
        System.out.println(LinenFormatter.header());
        System.out.print(LinenFormatter.format(linens));
        System.out.println(LinenFormatter.footer());
    }

    @Override
    public void findByFilter() {

    }
}
