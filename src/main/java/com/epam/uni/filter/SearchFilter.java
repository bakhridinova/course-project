package com.epam.uni.filter;

/**
 * record holding search properties
 *
 * @author bakhridinova
 */

public record SearchFilter(String sortType, String sortOrder,
                           String category, String material,
                           String description) {
}
