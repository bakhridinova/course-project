package com.epam.uni.entity;

import com.opencsv.bean.CsvBindByName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * marker class representing suppliances
 *
 * @author bakhridinova
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class Suppliance {
    @CsvBindByName
    private Long id;

    @CsvBindByName
    private Double price;

    @CsvBindByName
    private String description;

    @CsvBindByName(column = "left_in_stock")
    private Integer leftInStock;
}
