package com.epam.uni.format;

import com.epam.uni.dto.SupplianceDto;

import java.util.List;

public interface BaseFormatter<T extends SupplianceDto> {
    String header();

    String format(T dish);

    String format(List<T> dishes);

    String footer();
}
