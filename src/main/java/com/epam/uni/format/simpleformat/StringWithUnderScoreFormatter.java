package com.epam.uni.format.simpleformat;

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
