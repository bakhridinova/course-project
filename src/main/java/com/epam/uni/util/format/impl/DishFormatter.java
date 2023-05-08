package com.epam.uni.util.format.impl;

import com.epam.uni.dto.DishDto;
import com.epam.uni.util.format.BaseFormatter;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * utility class for formatting dishes
 *
 * @author bakhridinova
 */

@Component
public class DishFormatter implements BaseFormatter<DishDto> {

    public String header() {
        return "╭" + StringUtils.repeat("—", 11)
                + "┬" + StringUtils.repeat("—", 11)
                + "┬" + StringUtils.repeat("—", 11)
                + "┬" + StringUtils.repeat("—", 41)
                + "┬" + StringUtils.repeat("—", 21)
                + "┬" + StringUtils.repeat("—", 21)
                + "┬" + StringUtils.repeat("—", 16) + "╮" +

                String.format("\n│ %-10s│ %-10s│ %-10s│ %-40s│ %-20s│ %-20s│ %-15s│ \n",
                "id", "size", "price", "description", "category", "material", "left in stock") +

                "├" + StringUtils.repeat("—", 11)
                + "┼" + StringUtils.repeat("—", 11)
                + "┼" + StringUtils.repeat("—", 11)
                + "┼" + StringUtils.repeat("—", 41)
                + "┼" + StringUtils.repeat("—", 21)
                + "┼" + StringUtils.repeat("—", 21)
                + "┼" + StringUtils.repeat("—", 16) + "┤";
    }

    public String format(DishDto dish) {
        return String.format("│ %-10d│ %-10s│ %9.2f │ %-40s│ %-20s│ %-20s│ %-15d│ \n",
                dish.getId(),
                formatStringWithUnderScore(dish.getSize()),
                dish.getPrice(),
                dish.getDescription(),
                formatStringWithUnderScore(dish.getCategory()),
                formatStringWithUnderScore(dish.getMaterial()),
                dish.getLeftInStock());
    }

    public String format(List<DishDto> dishes) {
        StringBuilder formatted = new StringBuilder();
        dishes.forEach(dish -> formatted.append(format(dish)));
        return formatted.toString();
    }

    public String footer() {
        return "╰" + StringUtils.repeat("—", 11)
                + "┴" + StringUtils.repeat("—", 11)
                + "┴" + StringUtils.repeat("—", 11)
                + "┴" + StringUtils.repeat("—", 41)
                + "┴" + StringUtils.repeat("—", 21)
                + "┴" + StringUtils.repeat("—", 21)
                + "┴" + StringUtils.repeat("—", 16) + "╯";
    }
}
