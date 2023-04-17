package com.epam.uni.repository;

import com.epam.uni.entity.Linen;

import java.util.List;
import java.util.Optional;

/**
 * @author bakhridinova
 */

public interface LinenRepository extends CustomRepository<Linen> {
    @Override
    List<Linen> findAll();

    @Override
    Optional<Linen> findById(Long id);

    @Override
    List<Linen> findByCategory(Enum<?> category);

    @Override
    Linen create(Linen linen);

    @Override
    Linen update(Linen linen);

    @Override
    void delete(Linen linen);
}
