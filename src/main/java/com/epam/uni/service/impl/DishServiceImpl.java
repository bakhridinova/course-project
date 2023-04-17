package com.epam.uni.service.impl;

import com.epam.uni.dto.DishDto;
import com.epam.uni.entity.Dish;
import com.epam.uni.repository.CustomRepository;
import com.epam.uni.service.DishService;
import com.epam.uni.util.mapper.DishMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DishServiceImpl implements DishService {
    private final CustomRepository<Dish> dishRepository;
    private final DishMapper dishMapper;

    @Override
    public List<DishDto> findAll() {
        return null;
    }

    @Override
    public Optional<DishDto> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public List<DishDto> findByCategory(Enum<?> category) {
        return null;
    }

    @Override
    public DishDto create(DishDto dishDto) {
        return null;
    }

    @Override
    public DishDto update(DishDto dishDto) {
        return null;
    }

    @Override
    public void delete(DishDto dishDto) {

    }
}
