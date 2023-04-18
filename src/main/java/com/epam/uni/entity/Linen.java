package com.epam.uni.entity;

import com.epam.uni.entity.category.LinenCategory;
import com.epam.uni.entity.category.LinenMaterial;
import com.opencsv.bean.CsvBindByName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * entity representation of linens
 *
 * @author bakhridinova
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Linen extends Suppliance {
    @CsvBindByName
    private Long id;

    @CsvBindByName
    private Double price;

    @CsvBindByName
    private String description;

    @CsvBindByName(column = "left_in_stock")
    private Integer leftInStock;

    @CsvBindByName
    private LinenCategory category;

    @CsvBindByName
    private LinenMaterial material;
}
