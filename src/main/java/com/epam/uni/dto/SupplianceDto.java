package com.epam.uni.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * marker data transfer object class representing suppliances
 *
 * @author bakhridinova
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SupplianceDto {
    private Long id;
    private Double price;
    private String description;
    private Integer leftInStock;
    private String category;
    private String material;
}
