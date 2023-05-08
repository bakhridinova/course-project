package com.epam.uni.controller;

import com.epam.uni.dto.SupplianceDto;
import com.epam.uni.entity.enums.DishCategory;
import com.epam.uni.entity.enums.DishMaterial;
import com.epam.uni.entity.enums.LinenCategory;
import com.epam.uni.entity.enums.LinenMaterial;
import com.epam.uni.exception.CustomEntityNotFoundException;
import com.epam.uni.service.BaseService;
import com.epam.uni.util.filter.SearchFilter;
import com.epam.uni.util.format.BaseFormatter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * controller abstract class with needed
 * default methods
 *
 * @author bakhridinova
 */

@Component
@RequiredArgsConstructor
public abstract class BaseController<T extends SupplianceDto> {
    private final Scanner scanner;

    void findAll(BaseService<T> service, BaseFormatter<T> formatter) {
        List<T> entities = service.findAll();
        System.out.println(formatter.header());
        System.out.print(formatter.format(entities));
        System.out.println(formatter.footer());
    }

    void findById(BaseService<T> service, BaseFormatter<T> formatter, Class<T> tClass) {
        System.out.printf("please, enter id of %s you want to search for: ",
                getClassName(tClass, false));
        try {
            Long id = Long.parseLong(scanner.next());
            T entity = service.findById(id);
            System.out.println(formatter.header());
            System.out.print(formatter.format(entity));
            System.out.println(formatter.footer());
        } catch (NumberFormatException e) {
            System.out.println("id should be of type Long, enter command again to search by another value");
        } catch (CustomEntityNotFoundException e) {
            System.out.println(e.getMessage() + ", enter command again to search by another value");
        }
    }

    void findByCategory(BaseService<T> service, BaseFormatter<T> formatter, Class<T> tClass) {
        String name = getClassName(tClass, true);
        String category = getCategory(tClass, name.equals("linens") ?
                LinenCategory.values() : DishCategory.values());
        List<T> entities;
        if (category.equalsIgnoreCase("s")) {
            entities = service.findAll();
        } else {
            entities = service
                    .findByCategory(name.equals("linens") ?
                            LinenCategory.valueOf(category) : DishCategory.valueOf(category));
        }
        System.out.println(formatter.header());
        System.out.print(formatter.format(entities));
        System.out.println(formatter.footer());
    }

    void findByFilter(BaseService<T> service, BaseFormatter<T> formatter, Class<T> tClass) {
        String name = getClassName(tClass, true);
        String sortType = getSortType(tClass);
        String sortOrder = getSortOrder(tClass);
        String category = getCategory(tClass, name.equals("linens") ?
                LinenCategory.values() : DishCategory.values());
        String material = getMaterial(tClass, name.equals("linens") ?
                LinenMaterial.values() : DishMaterial.values());
        String description = getDescription(tClass);
        SearchFilter searchFilter = new SearchFilter(sortType, sortOrder, category, material, description);
        List<T> entities = service.findByFilter(searchFilter);
        System.out.println(formatter.header());
        System.out.print(formatter.format(entities));
        System.out.println(formatter.footer());
    }

    private String getCategory(Class<T> tclass, Enum<?>[] categoryEnum) {
        System.out.println("please enter category of " + getClassName(tclass, true) +
                " to search for, available categories: ");
        List<String> categories = Arrays.stream(categoryEnum)
                .map(Enum::name).filter(name -> !name.equals("TEST")).toList();
        categories.forEach(c -> System.out.print(c.toLowerCase() + ", "));
        System.out.print("s to skip: ");
        String category = scanner.next().toUpperCase();

        while (!categories.contains(category)) {
            if (category.equalsIgnoreCase("s")) {
                break;
            }

            System.out.print("please enter valid category: ");
            category = scanner.next().toUpperCase();
        }
        return category;
    }

    private String getSortType(Class<T> tClass) {
        System.out.print("please enter property by which " + getClassName(tClass, true) +
                " should be sorted, p for price, l for left in stock or s to skip: ");
        String sortType = scanner.next();
        while (!sortType.equalsIgnoreCase("p") &&
                !sortType.equalsIgnoreCase("l")) {

            if (sortType.equalsIgnoreCase("s")) {
                break;
            }

            System.out.print("please enter either p or l: ");
            sortType = scanner.next().toUpperCase();
        }
        return sortType;
    }

    private String getSortOrder(Class<T> tClass) {
        System.out.print("please enter order by which " + getClassName(tClass, true) +
                " should be sorted, a for ascending, d for descending or s to skip: ");
        String sortOrder = scanner.next();
        while (!sortOrder.equalsIgnoreCase("a") &&
                !sortOrder.equalsIgnoreCase("d")) {
            if (sortOrder.equalsIgnoreCase("s")) {
                break;
            }

            System.out.print("please enter either a or d: ");
            sortOrder = scanner.next().toUpperCase();
        }
        return sortOrder;
    }

    private String getMaterial(Class<T> tClass, Enum<?>[] materialEnum) {
        System.out.println("please enter material of " + getClassName(tClass, true) +
                " to search for, available materials: ");
        List<String> materials = Arrays.stream(materialEnum)
                .map(Enum::name).filter(name -> !name.equals("TEST")).toList();
        materials.forEach(c -> System.out.print(c.toLowerCase() + ", "));
        System.out.print("s to skip: ");
        String material = scanner.next().toUpperCase();

        while (!materials.contains(material)) {
            if (material.equalsIgnoreCase("s")) {
                break;
            }

            System.out.print("please enter valid material: ");
            material = scanner.next().toUpperCase();
        }
        return material;
    }

   private String getDescription(Class<T> tClass) {
        System.out.print("please enter description by which " + getClassName(tClass, true) +
                " should be searched or s to skip: ");
        return scanner.next();
    }

    /**
     * retrieves name of a class with
     * needed substrings replaced
     *
     * @param tClass specified cass
     * @param plural true if result must be in plural form, otherwise false
     * @return name of a class based on specified parameters
     */
    private String getClassName(Class<T> tClass, boolean plural) {
        String name = tClass.getSimpleName().toLowerCase().replace("dto", "");
        return plural ? name.equals("dish") ? name + "es" : name + "s" : name;
    }
}
