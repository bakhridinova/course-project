package com.epam.uni.util.formatter;

import com.epam.uni.dto.DishDto;
import lombok.experimental.UtilityClass;

import java.util.List;

/**
 * custom utility class for formatting dishes
 *
 * @author bakhridinova
 */

@UtilityClass
public class DishFormatter {
    public String header() {
        return String.format("%-10s%-10s%-15s%-40s%-20s%-20s%-10s\n", "id", "size",
                "price", "description", "category", "material", "left in stock");
    }

    public String format(DishDto dish) {
        return String.format("%-10d%-10s%-15f%-40s%-20s%-20s%-10d\n", dish.getId(), dish.getSize(),
                dish.getPrice(), dish.getDescription(), dish.getCategory(), dish.getMaterial(), dish.getLeftInStock());
    }

    public String format(List<DishDto> dishes) {
        StringBuilder formatted = new StringBuilder();
        dishes.forEach(dish -> formatted.append(format(dish)));
        return formatted.toString();
    }
}
