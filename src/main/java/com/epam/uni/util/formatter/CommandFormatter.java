package com.epam.uni.util.formatter;

import lombok.experimental.UtilityClass;
import org.apache.commons.lang3.StringUtils;

/**
 * custom utility class for formatting commands
 *
 * @author bakhridinova
 */

@UtilityClass
public class CommandFormatter {
    public String header() {
        return StringUtils.repeat("—", 55) +
                String.format("\n| %-30s| %-20s| \n", "command description", "command shortcut") +
                StringUtils.repeat("—", 55);
    }

    public String format(String description, String shortcut) {
        return String.format("| %-30s| %-20s| \n", description, shortcut);
    }

    public String footer() {
        return StringUtils.repeat("—", 55);
    }
}
