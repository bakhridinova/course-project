package com.epam.uni.util.method;

import com.epam.uni.BedclothesAndDishwashersApplication;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * custom annotation with method description and
 * short command to call it
 *
 * @see BedclothesAndDishwashersApplication#main
 * @see com.epam.uni.controller.DishController
 * @see com.epam.uni.controller.LinenController
 * @author bakhridinova
 */

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface MethodDescription {
    String value();

    String command();
}
