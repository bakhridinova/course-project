package com.epam.uni.service;

import com.epam.uni.dto.SupplianceDto;
import com.epam.uni.util.filter.SearchFilter;

import java.util.List;

/**
 * custom suppliance service
 *
 * @author bakhridinova
 */

public interface BaseService<T extends SupplianceDto> {
    /**
     * retrieves all suppliances
     *
     * @return list of suppliances
     */
    List<T> findAll();

    /**
     * retrieves suppliance with specified id
     *
     * @param id of suppliance
     * @return suppliance
     */
    T findById(Long id);

    /**
     * retrieves suppliances with specified category
     *
     * @return list of suppliances
     */
    List<T> findByCategory(Enum<?> category);

    /**
     * retrieves suppliances with specified search parameters
     *
     * @param filter holding search parameters
     * @return list of suppliances
     */
    List<T> findByFilter(SearchFilter filter);
}
