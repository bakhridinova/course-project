package com.epam.uni.util.formatter.simpleformat;

import lombok.experimental.UtilityClass;

/**
 * @author bakhridinova
 */

@UtilityClass
public class StringWithUnderScoreFormatter {
    public String format(String value) {
        return value.replace("_", " ").toLowerCase();
    }
}
