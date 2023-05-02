package com.epam.uni.format;

import com.epam.uni.dto.LinenDto;
import com.epam.uni.format.simpleformat.StringWithUnderScoreFormatter;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * custom utility class for formatting linens
 *
 * @author bakhridinova
 */

@Component
public class LinenFormatter implements BaseFormatter<LinenDto> {
    public String header() {
        return StringUtils.repeat("—", 133) +
                String.format("\n| %-10s| %-15s| %-40s| %-20s| %-20s| %-15s| \n",
                "id", "price", "description", "category", "material", "left in stock") +
                StringUtils.repeat("—", 133);
    }

    public String format(LinenDto linen) {
        return String.format("| %-10d| %10.2f| %-40s| %-20s| %-20s| %-15d| \n",
                linen.getId(),
                linen.getPrice(),
                linen.getDescription(),
                StringWithUnderScoreFormatter.format(linen.getCategory()),
                StringWithUnderScoreFormatter.format(linen.getMaterial()),
                linen.getLeftInStock());
    }

    public String format(List<LinenDto> linens) {
        StringBuilder formatted = new StringBuilder();
        linens.forEach(linen -> formatted.append(format(linen)));
        return formatted.toString();
    }

    public String footer() {
        return StringUtils.repeat("—", 133);
    }
}
