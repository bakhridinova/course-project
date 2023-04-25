package com.epam.uni.dto;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * data transfer object for linens
 *
 * @author bakhridinova
 */

@Data
@EqualsAndHashCode(callSuper = false)
public class LinenDto extends SupplianceDto {
    @Builder
    private LinenDto(Long id, Double price, String description, Integer leftInStock, String category, String material) {
        super(id, price, description, leftInStock, category, material);
    }
}
