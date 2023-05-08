package com.epam.uni.util.mapper;

import com.epam.uni.config.TestConfig;
import com.epam.uni.dto.DishDto;
import com.epam.uni.entity.Dish;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static com.epam.uni.data.TestDataStorage.getDish;
import static com.epam.uni.data.TestDataStorage.getDishDto;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = TestConfig.class)
class DishMapperTest {
    @Autowired
    private BaseMapper<Dish, DishDto> dishMapper;

    @Test
    void shouldMapDishesCorrectlyTest() {
        assertEquals(getDish(),
                dishMapper.toEntity(getDishDto()));
        assertEquals(getDishDto(),
                dishMapper.toEntityDto(getDish()));
    }

    @Test
    void shouldReturnNullIfNullPassedTest() {
        assertNull(dishMapper.toEntity(null));
        assertNull(dishMapper.toEntityDto(null));
    }

    @Test
    void shouldReturnNullObjectIfNullObjectPassedTest() {
        Dish dish = Dish.builder().build();
        DishDto dishDto = DishDto.builder().build();
        assertEquals(dish,
                dishMapper.toEntity(dishDto));
        assertEquals(dishDto,
                dishMapper.toEntityDto(dish));
    }
}