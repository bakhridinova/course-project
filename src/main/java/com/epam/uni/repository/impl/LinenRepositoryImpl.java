package com.epam.uni.repository.impl;

import com.epam.uni.entity.Linen;
import com.epam.uni.repository.LinenRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class LinenRepositoryImpl implements LinenRepository {
    @Override
    public List<Linen> findAll() {
        return null;
    }

    @Override
    public Optional<Linen> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public List<Linen> findByCategory(Enum<?> category) {
        return null;
    }

    @Override
    public Linen create(Linen linen) {
        return null;
    }

    @Override
    public Linen update(Linen linen) {
        return null;
    }

    @Override
    public void delete(Linen linen) {

    }
}
