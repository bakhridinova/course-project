package com.epam.uni.util.mapper;

import com.epam.uni.dto.SupplianceDto;
import com.epam.uni.entity.Suppliance;

/**
 * mapper converting entity to entity dto and vice versa
 *
 * @param <T1> of type suppliance
 * @param <T2> of type suppliance dto
 * @author bakhridinova
 */

public interface BaseMapper<T1 extends Suppliance, T2 extends SupplianceDto> {
    /**
     * maps entity to entity dto
     *
     * @param t1 entity to map
     * @return entity dto
     */
    T2 toEntityDto(T1 t1);

    /**
     * maps entity dto to entity
     *
     * @param t2 entity dto to map
     * @return entity
     */
    T1 toEntity(T2 t2);
}
