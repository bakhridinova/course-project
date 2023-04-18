package com.epam.uni.service;

import com.epam.uni.dto.DishDto;

import java.util.List;

/**
 * service holding business logic for dishes
 *
 * @author bakhridinova
 */

public interface DishService extends BaseService<DishDto> {
    @Override
    List<DishDto> findAll();

    @Override
    DishDto findById(Long id);

    @Override
    List<DishDto> findByCategory(Enum<?> category);

    @Override
    DishDto create(DishDto dishDto);

    @Override
    DishDto update(DishDto dishDto);

    @Override
    void delete(DishDto dishDto);
}
