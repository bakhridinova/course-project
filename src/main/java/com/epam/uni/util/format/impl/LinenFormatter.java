package com.epam.uni.util.format.impl;

import com.epam.uni.dto.LinenDto;
import com.epam.uni.util.format.BaseFormatter;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * utility class for formatting linens
 *
 * @author bakhridinova
 */

@Component
public class LinenFormatter implements BaseFormatter<LinenDto> {
    public String header() {
        return "╭" + StringUtils.repeat("—", 11)
                + "┬" + StringUtils.repeat("—", 11)
                + "┬" + StringUtils.repeat("—", 41)
                + "┬" + StringUtils.repeat("—", 21)
                + "┬" + StringUtils.repeat("—", 21)
                + "┬" + StringUtils.repeat("—", 16) + "╮" +

                String.format("\n│ %-10s│ %-10s│ %-40s│ %-20s│ %-20s│ %-15s│ \n",
                        "id", "price", "description", "category", "material", "left in stock") +

                "├" + StringUtils.repeat("—", 11)
                + "┼" + StringUtils.repeat("—", 11)
                + "┼" + StringUtils.repeat("—", 41)
                + "┼" + StringUtils.repeat("—", 21)
                + "┼" + StringUtils.repeat("—", 21)
                + "┼" + StringUtils.repeat("—", 16) + "┤";
    }

    public String format(LinenDto linen) {
        return String.format("│ %-10d│ %9.2f │ %-40s│ %-20s│ %-20s│ %-15d│ \n",
                linen.getId(),
                linen.getPrice(),
                linen.getDescription(),
                formatStringWithUnderScore(linen.getCategory()),
                formatStringWithUnderScore(linen.getMaterial()),
                linen.getLeftInStock());
    }

    public String format(List<LinenDto> linens) {
        StringBuilder formatted = new StringBuilder();
        linens.forEach(linen -> formatted.append(format(linen)));
        return formatted.toString();
    }

    public String footer() {
        return "╰" + StringUtils.repeat("—", 11)
                + "┴" + StringUtils.repeat("—", 11)
                + "┴" + StringUtils.repeat("—", 41)
                + "┴" + StringUtils.repeat("—", 21)
                + "┴" + StringUtils.repeat("—", 21)
                + "┴" + StringUtils.repeat("—", 16) + "╯";
    }
}
