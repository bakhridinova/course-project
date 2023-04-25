package com.epam.uni.repository;

import com.epam.uni.entity.Linen;
import com.epam.uni.filter.SearchFilter;

import java.util.List;

/**
 * repository for handling CRUD operations on linens
 *
 * @author bakhridinova
 */

public interface LinenRepository extends BaseRepository<Linen> {
    @Override
    List<Linen> findAll();

    @Override
    Linen findById(Long id);

    @Override
    List<Linen> findByCategory(Enum<?> category);

    @Override
    List<Linen> findByFilter(SearchFilter filter);
}
