package com.epam.uni.util.mapper;

import com.epam.uni.dto.DishDto;
import com.epam.uni.entity.Dish;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DishMapper extends BaseMapper<Dish, DishDto> {

}
