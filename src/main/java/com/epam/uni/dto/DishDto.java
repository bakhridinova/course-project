package com.epam.uni.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * data transfer object for dishes
 *
 * @author bakhridinova
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class DishDto extends SupplianceDto {
    protected Long id;
    protected Double price;
    protected String description;
    protected Integer leftInStock;
}
