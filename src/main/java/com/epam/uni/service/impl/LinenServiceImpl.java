package com.epam.uni.service.impl;

import com.epam.uni.dto.LinenDto;
import com.epam.uni.entity.Linen;
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
        return linenRepository.findAll().stream()
                .map(linenMapper::toLinenDto).toList();
    }

    @Override
    public LinenDto findById(Long id) {
        return linenMapper.toLinenDto(linenRepository.findById(id));
    }

    @Override
    public List<LinenDto> findByCategory(Enum<?> category) {
        return linenRepository.findByCategory(category).stream()
                .map(linenMapper::toLinenDto).toList();
    }

    @Override
    public LinenDto create(LinenDto linenDto) {
        return linenMapper.toLinenDto(
                linenRepository.create(linenMapper.toLinen(linenDto)));
    }

    @Override
    public LinenDto update(LinenDto linenDto) {
        return linenMapper.toLinenDto(
                linenRepository.update(linenMapper.toLinen(linenDto)));
    }

    @Override
    public void delete(Long id) {
        Linen linen = linenRepository.findById(id);
        linenRepository.delete(linen);
    }
}
