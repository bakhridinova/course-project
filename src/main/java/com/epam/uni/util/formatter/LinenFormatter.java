package com.epam.uni.util.formatter;

import com.epam.uni.dto.LinenDto;
import com.epam.uni.util.formatter.format.DecimalToTwoPointsFormatter;
import com.epam.uni.util.formatter.format.StringWithUnderScoreFormatter;
import lombok.experimental.UtilityClass;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

/**
 * custom utility class for formatting linens
 *
 * @author bakhridinova
 */

@UtilityClass
public class LinenFormatter {
    public String header() {
        return StringUtils.repeat("—", 133) +
                String.format("\n| %-10s| %-15s| %-40s| %-20s| %-20s| %-15s| \n",
                "id", "price", "description", "category", "material", "left in stock") +
                StringUtils.repeat("—", 133);
    }

    public String format(LinenDto linen) {
        return String.format("| %-10d| %-15s| %-40s| %-20s| %-20s| %-15d| \n",
                linen.getId(),
                DecimalToTwoPointsFormatter.format(linen.getPrice()),
                linen.getDescription(),
                StringWithUnderScoreFormatter.format(linen.getCategory()),
                StringWithUnderScoreFormatter.format(linen.getMaterial()),
                linen.getLeftInStock());
    }

    public String format(List<LinenDto> linens) {
        StringBuilder formatted = new StringBuilder();
        linens.forEach(dish -> formatted.append(format(dish)));
        return formatted.toString();
    }

    public String footer() {
        return StringUtils.repeat("—", 133);
    }
}
