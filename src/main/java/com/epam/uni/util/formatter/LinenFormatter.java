package com.epam.uni.util.formatter;

import com.epam.uni.dto.LinenDto;
import lombok.experimental.UtilityClass;

import java.util.List;

/**
 * custom utility class for formatting linens
 *
 * @author bakhridinova
 */

@UtilityClass
public class LinenFormatter {
    public String header() {
        return String.format("%-10s%-15s%-40s%-20s%-20s%-10s\n", "id",
                "price", "description", "category", "material", "left in stock");
    }

    public String format(LinenDto linen) {
        return String.format("%-10d%-15f%-40s%-20s%-20s%-10d\n", linen.getId(), linen.getPrice(),
                linen.getDescription(), linen.getCategory(), linen.getMaterial(), linen.getLeftInStock());
    }

    public String format(List<LinenDto> linens) {
        StringBuilder formatted = new StringBuilder();
        linens.forEach(dish -> formatted.append(format(dish)));
        return formatted.toString();
    }
}
