package com.epam.uni.service.impl;

import com.epam.uni.dto.DishDto;
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
        return null;
    }

    @Override
    public DishDto findById(Long id) {
        return null;
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
