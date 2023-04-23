package com.epam.uni.service;

import com.epam.uni.dto.LinenDto;

import java.util.List;

/**
 * service holding business logic for linens
 *
 * @author bakhridinova
 */

public interface LinenService extends BaseService<LinenDto> {
    @Override
    List<LinenDto> findAll();

    @Override
    LinenDto findById(Long id);

    @Override
    List<LinenDto> findByCategory(Enum<?> category);

    @Override
    LinenDto create(LinenDto linenDto);

    @Override
    LinenDto update(LinenDto linenDto);

    @Override
    void delete(Long id);
}
