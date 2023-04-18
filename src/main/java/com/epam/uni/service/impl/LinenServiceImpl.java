package com.epam.uni.service.impl;

import com.epam.uni.dto.LinenDto;
import com.epam.uni.repository.LinenRepository;
import com.epam.uni.service.LinenService;
import com.epam.uni.util.mapper.LinenMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LinenServiceImpl implements LinenService {
    private final LinenRepository linenRepository;
    private final LinenMapper linenMapper;
    @Override
    public List<LinenDto> findAll() {
        return null;
    }

    @Override
    public LinenDto findById(Long id) {
        return null;
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
