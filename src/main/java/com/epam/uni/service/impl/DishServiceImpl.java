package com.epam.uni.service.impl;

import com.epam.uni.dto.DishDto;
import com.epam.uni.filter.SearchFilter;
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
    public List<DishDto> findByFilter(SearchFilter filter) {
        return dishRepository.findByFilter(filter).stream()
                .map(dishMapper::toDishDto).toList();
    }
}
