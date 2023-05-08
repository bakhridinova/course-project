package com.epam.uni.data;

import com.epam.uni.dto.DishDto;
import com.epam.uni.dto.LinenDto;
import com.epam.uni.entity.Dish;
import com.epam.uni.entity.Linen;
import com.epam.uni.entity.enums.DishCategory;
import com.epam.uni.entity.enums.DishMaterial;
import com.epam.uni.entity.enums.LinenCategory;
import com.epam.uni.entity.enums.LinenMaterial;
import com.epam.uni.entity.enums.Size;
import lombok.experimental.UtilityClass;

@UtilityClass
public class TestDataStorage {
    private static final Dish DISH;
    private static final DishDto DISH_DTO;
    private static final Linen LINEN;
    private static final LinenDto LINEN_DTO;

    static {
        DISH = Dish.builder().id(0L).price(0.0).description("").leftInStock(0)
                .size(Size.TEST).category(DishCategory.TEST).material(DishMaterial.TEST).build();
        DISH_DTO = DishDto.builder().id(0L).price(0.0).description("").leftInStock(0)
                .size("TEST").material("TEST").category("TEST").build();

        LINEN = Linen.builder().id(0L).price(0.0).description("").leftInStock(0)
                .category(LinenCategory.TEST).material(LinenMaterial.TEST).build();
        LINEN_DTO = LinenDto.builder().id(0L).price(0.0).description("").leftInStock(0)
                .material("TEST").category("TEST").build();
    }

    public static Dish getDish() {
        return DISH;
    }

    public static Linen getLinen() {
        return LINEN;
    }

    public static DishDto getDishDto() {
        return DISH_DTO;
    }

    public static LinenDto getLinenDto() {
        return LINEN_DTO;
    }
}
