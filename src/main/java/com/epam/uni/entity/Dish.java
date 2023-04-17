package com.epam.uni.entity;

import com.epam.uni.entity.category.DishCategory;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * entity representation of dishes
 *
 * @author bakhridinova
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Dish extends Suppliance {
    private Long id;
    private Double price;
    private String description;
    private Integer leftInStock;
    private DishCategory category;
}
