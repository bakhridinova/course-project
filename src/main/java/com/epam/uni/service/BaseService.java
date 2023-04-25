package com.epam.uni.service;

import com.epam.uni.dto.SupplianceDto;

import java.util.List;

/**
 * custom suppliance service
 *
 * @author bakhridinova
 */

public interface BaseService<T extends SupplianceDto> {
    List<T> findAll();
    T findById(Long id);
    List<T> findByCategory(Enum<?> category);
}
