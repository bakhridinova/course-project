package com.epam.uni.util.format;

import com.epam.uni.dto.SupplianceDto;

import java.util.List;

public interface BaseFormatter<T extends SupplianceDto> {
    /**
     * formats table's header
     *
     * @return row representation of specified header
     */
    String header();

    /**
     * formats entity into table row
     *
     * @param t entity to format
     * @return row representation of specified entity
     */
    String format(T t);

    /**
     * formats entities into table rows
     * delimited by \n
     *
     * @param ts entities to format
     * @return row representation of specified entities
     */
    String format(List<T> ts);

    /**
     * formats table's footer
     *
     * @return row representation of specified footer
     */
    String footer();

    /**
     * formats strings with underscore
     *
     * @param value to format
     * @return new value with underscores replaced by spaces in lower case
     */
    default String formatStringWithUnderScore(String value) {
        return value.replace("_", " ").toLowerCase();
    }
}
