package com.epam.uni.service;

import com.epam.uni.dto.SupplianceDto;

import java.util.List;
import java.util.Optional;

/**
 * custom suppliance service
 *
 * @author bakhridinova
 */

public interface CustomService<T extends SupplianceDto> {
    List<T> findAll();
    Optional<T> findById(Long id);
    List<T> findByCategory(Enum<?> category);
    T create(T t);
    T update(T t);
    void  delete(T t);
}
