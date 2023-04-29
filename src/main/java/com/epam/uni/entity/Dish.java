package com.epam.uni.entity;

import com.epam.uni.entity.enums.DishCategory;
import com.epam.uni.entity.enums.DishMaterial;
import com.epam.uni.entity.enums.Size;
import com.opencsv.bean.CsvBindByName;
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
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Dish extends Suppliance {

    @CsvBindByName
    private Size size;

    @CsvBindByName
    private DishCategory category;

    @CsvBindByName
    private DishMaterial material;

    @Builder
    private Dish(Long id, Double price, String description, Integer leftInStock, Size size,
                 DishCategory category, DishMaterial material) {
        super(id, price, description, leftInStock);
        this.size = size;
        this.category = category;
        this.material = material;
    }
}
