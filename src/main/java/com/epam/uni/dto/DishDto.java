package com.epam.uni.dto;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * data transfer object for dishes
 *
 * @author bakhridinova
 */

@Data
@EqualsAndHashCode(callSuper = false)
public class DishDto extends SupplianceDto {
    private String size;

    @Builder
    private DishDto(Long id, Double price, String description, Integer leftInStock, String category, String material,
                    String size) {
        super(id, price, description, leftInStock, category, material);
        this.size = size;
    }
}
