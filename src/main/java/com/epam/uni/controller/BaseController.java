package com.epam.uni.controller;

import com.epam.uni.dto.SupplianceDto;
import com.epam.uni.entity.enums.DishCategory;
import com.epam.uni.entity.enums.DishMaterial;
import com.epam.uni.filter.SearchFilter;
import com.epam.uni.format.BaseFormatter;
import com.epam.uni.service.BaseService;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * controller interface with needed
 * default methods
 *
 * @author bakhridinova
 */

public abstract class BaseController<T extends SupplianceDto> {
    void findAll(BaseService<T> service, BaseFormatter<T> formatter) {
        List<T> entities = service.findAll();
        System.out.println(formatter.header());
        System.out.print(formatter.format(entities));
        System.out.println(formatter.footer());
    }

    void findById(Scanner scanner, BaseService<T> service, BaseFormatter<T> formatter, Class<T> tClass) {
        System.out.printf("please, enter id of %s you want to search for: ",
                getClassName(tClass));
        Long id = scanner.nextLong();
        T entity = service.findById(id);
        System.out.println(formatter.header());
        System.out.print(formatter.format(entity));
        System.out.println(formatter.footer());
    }

    void findByCategory(Scanner scanner, BaseService<T> service, BaseFormatter<T> formatter, Class<T> tClass) {
        System.out.printf("please, enter category of %s you want to search for: ",
                getClassName(tClass));
        String category = getCategory(scanner, tClass, DishCategory.values());
        List<T> entities = service
                .findByCategory(DishCategory.valueOf(category));
        System.out.println(formatter.header());
        System.out.print(formatter.format(entities));
        System.out.println(formatter.footer());
    }

    void findByFilter(Scanner scanner, BaseService<T> service, BaseFormatter<T> formatter, Class<T> tClass) {
        String sortType = getSortType(scanner, tClass);
        String sortOrder = getSortOrder(scanner, tClass);
        String category = getCategory(scanner, tClass, DishCategory.values());
        String material = getMaterial(scanner, tClass, DishMaterial.values());
        String description = getDescription(scanner, tClass);
        SearchFilter searchFilter = new SearchFilter(sortType, sortOrder, category, material, description);
        List<T> entities = service.findByFilter(searchFilter);
        System.out.println(formatter.header());
        System.out.print(formatter.format(entities));
        System.out.println(formatter.footer());
    }

    private String getCategory(Scanner scanner, Class<T> tclass, Enum<?>[] categoryEnum) {
        System.out.println("please enter category of " + getClassName(tclass) +
                " to search for, available categories: ");
        List<String> categories = Arrays.stream(categoryEnum)
                .map(Enum::name).map(String::toLowerCase).toList();
        categories.forEach(c -> System.out.print(c + ", "));
        System.out.println("s to skip: ");
        String category = scanner.next();

        while (!categories.contains(category)) {
            if (category.equals("s")) {
                break;
            }

            System.out.print("please enter valid category: ");
            category = scanner.next();
        }
        return category;
    }

    private String getSortType(Scanner scanner, Class<T> tClass) {
        System.out.print("please enter property by which " + getClassName(tClass) +
                " should be sorted, p for price, l for left in stock or s to skip: ");
        String sortType = scanner.next();
        while (!sortType.equals("p") &&
                !sortType.equals("l")) {

            if (sortType.equals("s")) {
                break;
            }

            System.out.print("please enter either p or l: ");
            sortType = scanner.next();
        }
        return sortType;
    }

    private String getSortOrder(Scanner scanner, Class<T> tClass) {
        System.out.print("please enter order by which " + getClassName(tClass) +
                " should be sorted, a for ascending, d for descending or s to skip: ");
        String sortOrder = scanner.next();
        while (!sortOrder.equals("a") &&
                !sortOrder.equals("d")) {
            if (sortOrder.equals("s")) {
                break;
            }

            System.out.print("please enter either a or d: ");
            sortOrder = scanner.next();
        }
        return sortOrder;
    }

    private String getMaterial(Scanner scanner, Class<T> tClass, Enum<?>[] materialEnum) {
        System.out.println("please enter material of " + getClassName(tClass) +
                "s to search for, available materials: ");
        List<String> materials = Arrays.stream(materialEnum)
                .map(Enum::name).map(String::toLowerCase).toList();
        materials.forEach(c -> System.out.print(c + ", "));
        System.out.println("s to skip");
        String material = scanner.next();

        while (!materials.contains(material)) {
            if (material.equals("s")) {
                break;
            }

            System.out.print("please enter valid material: ");
            material = scanner.next();
        }
        return material;
    }

    private String getDescription(Scanner scanner, Class<T> tClass) {
        System.out.print("please enter description by which " + getClassName(tClass) +
                "s should be searched or s to skip: ");
        return scanner.next();
    }

    private String getClassName(Class<T> tClass) {
        String name = tClass.getName().substring(tClass.getName()
                .lastIndexOf(".") + 1).toLowerCase().replace("dto", "");
        return name.equals("dish") ? name + "es" : name + "s";
    }
}
