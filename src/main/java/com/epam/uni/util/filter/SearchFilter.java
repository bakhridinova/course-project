package com.epam.uni.util.filter;

/**
 * record holding search properties
 *
 * @author bakhridinova
 */

public record SearchFilter(String sortType, String sortOrder,
                           String category, String material,
                           String description) {
    public boolean isDescending() {
        return sortOrder.equalsIgnoreCase("d");
    }

    public String material() {
        return material.toUpperCase();
    }

    public String category() {
        return category.toUpperCase();
    }
}
