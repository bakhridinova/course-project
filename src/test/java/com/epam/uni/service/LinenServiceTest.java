package com.epam.uni.service;

import com.epam.uni.config.TestConfig;
import com.epam.uni.exception.CustomEntityNotFoundException;
import com.epam.uni.repository.LinenRepository;
import com.epam.uni.repository.impl.LinenRepositoryImpl;
import com.epam.uni.service.impl.LinenServiceImpl;
import com.epam.uni.util.mapper.LinenMapper;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static com.epam.uni.data.TestDataStorage.getLinen;
import static com.epam.uni.data.TestDataStorage.getLinenDto;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = TestConfig.class)
class LinenServiceTest {
    @Mock
    private static LinenRepository linenRepository;
    @Mock
    private static LinenMapper linenMapper;
    @InjectMocks
    private static LinenService linenService;

    @BeforeAll
    public static void setUp() {
        linenRepository = mock(LinenRepositoryImpl.class);
        linenMapper = mock(LinenMapper.class);
        linenService = new LinenServiceImpl(linenRepository, linenMapper);
    }

    @Test
    void shouldReturnListWithCorrectSizeAndElement() {
        when(linenRepository.findAll())
                .thenReturn(List.of(getLinen()));
        when(linenMapper.toEntityDto(any()))
                .thenReturn(getLinenDto());

        assertEquals(1,
                linenService.findAll().size());
        assertEquals(List.of(getLinenDto()),
                linenService.findAll());
    }

    @Test
    void shouldThrowExceptionIfEntityNotFoundExceptionWasThrown() {
        doThrow(new CustomEntityNotFoundException(""))
                .when(linenRepository).findById(anyLong());

        assertThrows(CustomEntityNotFoundException.class,
                () -> linenService.findById(anyLong()));
    }

    @Test
    void shouldReturnObjectWithCorrectId() {
        when(linenRepository.findById(anyLong()))
                .thenReturn(getLinen());
        when(linenMapper.toEntityDto(any()))
                .thenReturn(getLinenDto());

        assertEquals(0L,
                linenService.findById(0L).getId());
        assertEquals(getLinenDto(),
                linenService.findById(0L));
    }
}