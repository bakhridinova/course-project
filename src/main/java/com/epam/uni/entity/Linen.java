package com.epam.uni.entity;

import com.epam.uni.entity.category.LinenCategory;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * entity representation of linens
 *
 * @author bakhridinova
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Linen extends Suppliance {
    private Long id;
    private Double price;
    private String description;
    private Integer leftInStock;
    private LinenCategory category;
}
