package com.epam.uni.service;

import com.epam.uni.dto.LinenDto;

import java.util.List;
import java.util.Optional;

/**
 * service holding business logic for linens
 *
 * @author bakhridinova
 */

public interface LinenService extends CustomService<LinenDto> {
    @Override
    List<LinenDto> findAll();

    @Override
    Optional<LinenDto> findById(Long id);

    @Override
    List<LinenDto> findByCategory(Enum<?> category);

    @Override
    LinenDto create(LinenDto linenDto);

    @Override
    LinenDto update(LinenDto linenDto);

    @Override
    void delete(LinenDto linenDto);
}
