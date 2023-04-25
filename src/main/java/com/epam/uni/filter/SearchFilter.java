package com.epam.uni.filter;

/**
 * record holding search properties
 *
 * @author bakhridinova
 */

public record SearchFilter(String sortType, String sortOrder,
                           Double minPrice, Double maxPrice,
                           Integer minLeft, Integer maxLeft,
                           String category, String price,
                           String size, String description) {
}
