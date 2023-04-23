package com.epam.uni.service.impl;

import com.epam.uni.dto.DishDto;
import com.epam.uni.entity.Dish;
import com.epam.uni.repository.DishRepository;
import com.epam.uni.service.DishService;
import com.epam.uni.util.mapper.DishMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DishServiceImpl implements DishService {
    private final DishRepository dishRepository;
    private final DishMapper dishMapper;

    @Override
    public List<DishDto> findAll() {
        return dishRepository.findAll().stream()
                .map(dishMapper::toDishDto).toList();
    }

    @Override
    public DishDto findById(Long id) {
        return dishMapper.toDishDto(dishRepository.findById(id));
    }

    @Override
    public List<DishDto> findByCategory(Enum<?> category) {
        return dishRepository.findByCategory(category).stream()
                .map(dishMapper::toDishDto).toList();
    }

    @Override
    public DishDto create(DishDto dishDto) {
        return dishMapper.toDishDto(
                dishRepository.create(dishMapper.toDish(dishDto)));
    }

    @Override
    public DishDto update(DishDto dishDto) {
        return dishMapper.toDishDto(
                dishRepository.update(dishMapper.toDish(dishDto)));
    }

    @Override
    public void delete(Long id) {
        Dish dish = dishRepository.findById(id);
        dishRepository.delete(dish);
    }
}
