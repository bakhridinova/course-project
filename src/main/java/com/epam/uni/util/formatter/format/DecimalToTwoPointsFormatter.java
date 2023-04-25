package com.epam.uni.util.formatter.format;

import lombok.experimental.UtilityClass;

import java.text.DecimalFormat;

/**
 * @author bakhridinova
 */

@UtilityClass
public class DecimalToTwoPointsFormatter {
    private final DecimalFormat decimalFormat;

    static {
        decimalFormat = new DecimalFormat();
        decimalFormat.setMaximumFractionDigits(2);
    }


    public String format(Double value) {
        return decimalFormat.format(value);
    }
}
