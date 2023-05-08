package com.epam.uni.service.impl;

import com.epam.uni.dto.LinenDto;
import com.epam.uni.repository.LinenRepository;
import com.epam.uni.service.LinenService;
import com.epam.uni.util.filter.SearchFilter;
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
        return linenRepository.findAll().stream()
                .map(linenMapper::toEntityDto).toList();
    }

    @Override
    public LinenDto findById(Long id) {
        return linenMapper.toEntityDto(linenRepository.findById(id));
    }

    @Override
    public List<LinenDto> findByCategory(Enum<?> category) {
        return linenRepository.findByCategory(category).stream()
                .map(linenMapper::toEntityDto).toList();
    }

    @Override
    public List<LinenDto> findByFilter(SearchFilter filter) {
        return linenRepository.findByFilter(filter).stream()
                .map(linenMapper::toEntityDto).toList();
    }
}
