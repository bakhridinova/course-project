package com.epam.uni.format;

import com.epam.uni.dto.DishDto;
import com.epam.uni.format.simpleformat.StringWithUnderScoreFormatter;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * custom utility class for formatting dishes
 *
 * @author bakhridinova
 */

@Component
public class DishFormatter implements BaseFormatter<DishDto> {

    public String header() {
        return StringUtils.repeat("—", 140) +
                String.format("\n| %-10s| %-10s| %-10s| %-40s| %-20s| %-20s| %-15s| \n",
                "id", "size", "price", "description", "category", "material", "left in stock") +
                StringUtils.repeat("—", 140);
    }

    public String format(DishDto dish) {
        return String.format("| %-10d| %-10s| %10.2f| %-40s| %-20s| %-20s| %-15d| \n",
                dish.getId(),
                StringWithUnderScoreFormatter.format(dish.getSize()),
                dish.getPrice(),
                dish.getDescription(),
                StringWithUnderScoreFormatter.format(dish.getCategory()),
                StringWithUnderScoreFormatter.format(dish.getMaterial()),
                dish.getLeftInStock());
    }

    public String format(List<DishDto> dishes) {
        StringBuilder formatted = new StringBuilder();
        dishes.forEach(dish -> formatted.append(format(dish)));
        return formatted.toString();
    }

    public String footer() {
        return StringUtils.repeat("—", 140);
    }
}
