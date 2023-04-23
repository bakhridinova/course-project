package com.epam.uni.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * data transfer object for dishes
 *
 * @author bakhridinova
 */

@Data
@Builder
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class DishDto extends SupplianceDto {
    private Long id;
    private String size;
    private Double price;
    private String description;
    private Integer leftInStock;
    private String category;
    private String material;
}
