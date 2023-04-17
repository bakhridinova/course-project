package com.epam.uni.service.impl;

import com.epam.uni.dto.LinenDto;
import com.epam.uni.entity.Linen;
import com.epam.uni.repository.CustomRepository;
import com.epam.uni.service.LinenService;
import com.epam.uni.util.mapper.LinenMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LinenServiceImpl implements LinenService {
    private final CustomRepository<Linen> linenRepository;
    private final LinenMapper linenMapper;
    @Override
    public List<LinenDto> findAll() {
        return null;
    }

    @Override
    public Optional<LinenDto> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public List<LinenDto> findByCategory(Enum<?> category) {
        return null;
    }

    @Override
    public LinenDto create(LinenDto linenDto) {
        return null;
    }

    @Override
    public LinenDto update(LinenDto linenDto) {
        return null;
    }

    @Override
    public void delete(LinenDto linenDto) {

    }
}
