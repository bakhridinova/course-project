package com.epam.uni.util.format.impl;

import lombok.experimental.UtilityClass;
import org.apache.commons.lang3.StringUtils;

/**
 * utility class for formatting commands
 *
 * @author bakhridinova
 */

@UtilityClass
public class CommandFormatter {
    public String header() {
        return "╭" + StringUtils.repeat("—", 31) +
                "┬" + StringUtils.repeat("—", 21) + "╮" +

                String.format("\n│ %-30s│ %-20s│ \n",
                        "command description", "command shortcut") +

                "├" + StringUtils.repeat("—", 31) +
                "┼" + StringUtils.repeat("—", 21) + "┤";
    }

    public String format(String description, String shortcut) {
        return String.format("│ %-30s│ %-20s│ \n", description, shortcut);
    }

    public String footer() {
        return "╰" + StringUtils.repeat("—", 31) +
                "┴" + StringUtils.repeat("—", 21) + "╯";
    }
}
