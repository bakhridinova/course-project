package com.epam.uni.repository.impl;

import com.epam.uni.entity.Linen;
import com.epam.uni.exception.CustomEntityNotFoundException;
import com.epam.uni.filter.SearchFilter;
import com.epam.uni.repository.LinenRepository;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.StatefulBeanToCsv;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;

@Repository
@RequiredArgsConstructor
public class LinenRepositoryImpl implements LinenRepository {
    private final ObjectProvider<CsvToBeanBuilder<Linen>> linenBeanBuilderProvider;

    private List<Linen> getParsedLinens() {
        return Objects.requireNonNull(linenBeanBuilderProvider.getIfAvailable())
                .withType(Linen.class).build().parse();
    }

    @Override
    public List<Linen> findAll() {
        return getParsedLinens();
    }

    @Override
    public Linen findById(Long id) {
        return getParsedLinens().stream()
                .filter(linen -> linen.getId().equals(id)).findAny()
                .orElseThrow(() -> new CustomEntityNotFoundException("failed to find linen with id " + id));
    }

    @Override
    public List<Linen> findByCategory(Enum<?> category) {
        return getParsedLinens().stream()
                .filter(linen -> linen.getCategory().equals(category)).toList();
    }

    @Override
    public List<Linen> findByFilter(SearchFilter filter) {
        return null;
    }
}
