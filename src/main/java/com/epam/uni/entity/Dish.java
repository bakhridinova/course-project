package com.epam.uni.entity;

import com.epam.uni.entity.category.DishCategory;
import com.epam.uni.entity.category.DishMaterial;
import com.epam.uni.entity.category.Size;
import com.opencsv.bean.CsvBindByName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * entity representation of dishes
 *
 * @author bakhridinova
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Dish extends Suppliance {
    @CsvBindByName
    private Long id;

    @CsvBindByName
    private Size size;

    @CsvBindByName
    private Double price;

    @CsvBindByName
    private String description;

    @CsvBindByName(column = "left_in_stock")
    private Integer leftInStock;

    @CsvBindByName
    private DishCategory category;

    @CsvBindByName
    private DishMaterial material;
}
