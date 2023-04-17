package com.epam.uni.util.mapper;

import com.epam.uni.dto.DishDto;
import com.epam.uni.entity.Dish;
import org.mapstruct.Mapper;

/**
 * mapper converting dish to dish dto and vice versa
 *
 * @author bakhridinova
 */

@Mapper(componentModel = "spring")
public interface DishMapper {
    Dish toDish(DishDto dish);
    DishDto toDishDto(Dish dish);
}
