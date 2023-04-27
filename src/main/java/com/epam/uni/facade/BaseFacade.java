package com.epam.uni.facade;

import com.epam.uni.dto.SupplianceDto;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * interface hiding controller method bodies
 *
 * @author bakhridinova
 */

public interface BaseFacade<T extends SupplianceDto> {
    void findAll();
    void findById();
    void findByCategory();
    void findByFilter();

    default String getSortType(Scanner scanner, Class<T> tClass) {
        System.out.print("please enter property by which " + getClassName(tClass) +
                "s should be sorted, p for price, l for left in stock or skip to skip: ");
        String sortType = scanner.next();
        while (!sortType.equals("p") &&
                !sortType.equals("l")) {

            if (sortType.equals("skip")) {
                sortType = "d";
                break;
            }

            System.out.print("please enter either p or l");
            sortType = scanner.next();
        }
        return sortType;
    }

    default String getSortOrder(Scanner scanner, Class<T> tClass) {
        System.out.print("please enter order by which " + getClassName(tClass) +
                "s should be sorted, a for ascending, d for descending or skip to skip: ");
        String sortOrder = scanner.next();
        while (!sortOrder.equals("a") &&
                !sortOrder.equals("d")) {
            if (sortOrder.equals("skip")) {
                sortOrder = "a";
                break;
            }

            System.out.print("please enter either a or d");
            sortOrder = scanner.next();
        }
        return sortOrder;
    }

    default String getCategory(Scanner scanner, Class<T> tclass, Enum<?>[] categoryEnum) {
        System.out.println("please enter category of " + getClassName(tclass) +
                "s to search for, available categories: ");
        List<String> categories =
                Arrays.stream(categoryEnum).map(Enum::name).toList();
        categories.forEach(c -> System.out.print(c.toLowerCase() + ", "));
        System.out.println("skip to skip: ");
        String category = scanner.next();

        while (!categories.contains(category)) {
            if (category.equals("skip")) {
                category = null;
                break;
            }

            System.out.println("please enter valid category");
            category = scanner.next();
        }
        return category;
    }

    default String getMaterial(Scanner scanner, Class<T> tClass, Enum<?>[] materialEnum) {
        System.out.println("please enter material of " + getClassName(tClass) +
                "s to search for, available materials: ");
        List<String> materials = Arrays.stream(materialEnum).map(Enum::name).toList();
        materials.forEach(c -> System.out.print(c.toLowerCase() + ", "));
        System.out.println("skip to skip");
        String material = scanner.next();

        while (!materials.contains(material)) {
            if (material.equals("skip")) {
                material = null;
                break;
            }

            System.out.println("please enter valid material");
            material = scanner.next();
        }
        return material;
    }

    default String getDescription(Scanner scanner, Class<T> tClass) {
        System.out.print("please enter description by which " + getClassName(tClass) +
                "s should be searched or skip to skip: ");
        String description = scanner.next();
        if (description.equals("skip")) {
            description = "";
        }
        return description;
    }

    default String getClassName(Class<T> tClass) {
        return tClass.getName().substring(tClass.getName().lastIndexOf(".") + 1).toLowerCase();
    }
}
