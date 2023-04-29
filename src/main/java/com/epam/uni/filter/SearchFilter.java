package com.epam.uni.filter;

/**
 * record holding search properties
 *
 * @author bakhridinova
 */

public record SearchFilter(String sortType, String sortOrder,
                           String category, String material,
                           String description) {
    public boolean isDescending() {
        return sortOrder.equals("d");
    }

    public String material() {
        return material.toUpperCase();
    }

    public String category() {
        return category.toUpperCase();
    }
}
