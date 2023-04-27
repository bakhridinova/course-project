package com.epam.uni.entity;

import com.epam.uni.entity.enums.LinenCategory;
import com.epam.uni.entity.enums.LinenMaterial;
import com.opencsv.bean.CsvBindByName;
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
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Linen extends Suppliance {
    @CsvBindByName
    private LinenCategory category;

    @CsvBindByName
    private LinenMaterial material;

    @Builder
    private Linen(Long id, Double price, String description, Integer leftInStock,
                  LinenCategory category, LinenMaterial material) {
        super(id, price, description, leftInStock);
        this.category = category;
        this.material = material;
    }
}
