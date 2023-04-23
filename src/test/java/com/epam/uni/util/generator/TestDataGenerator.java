package com.epam.uni.util.generator;

import com.epam.uni.entity.Dish;
import com.epam.uni.entity.Linen;
import com.epam.uni.entity.enumerator.DishCategory;
import com.epam.uni.entity.enumerator.DishMaterial;
import com.epam.uni.entity.enumerator.LinenCategory;
import com.epam.uni.entity.enumerator.LinenMaterial;
import com.epam.uni.entity.enumerator.Size;
import lombok.experimental.UtilityClass;

@UtilityClass
public class TestDataGenerator {
    private static final Dish DISH;
    private static final Linen LINEN;

    static {
        DISH = Dish.builder().id(0L).size(Size.TEST).price(0.0).description("").leftInStock(0)
                .category(DishCategory.TEST).material(DishMaterial.TEST).build();
        LINEN = Linen.builder().id(0L).price(0.0).description("").leftInStock(0)
                .category(LinenCategory.TEST).material(LinenMaterial.TEST).build();
    }

    public static Dish getDish() {
        return DISH;
    }

    public static Linen getLinen() {
        return LINEN;
    }
}
