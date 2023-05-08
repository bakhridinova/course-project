package com.epam.uni.service;

import com.epam.uni.config.TestConfig;
import com.epam.uni.exception.CustomEntityNotFoundException;
import com.epam.uni.repository.DishRepository;
import com.epam.uni.repository.impl.DishRepositoryImpl;
import com.epam.uni.service.impl.DishServiceImpl;
import com.epam.uni.util.mapper.DishMapper;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static com.epam.uni.data.TestDataStorage.getDish;
import static com.epam.uni.data.TestDataStorage.getDishDto;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = TestConfig.class)
class DishServiceTest {
    @Mock
    private static DishRepository dishRepository;
    @Mock
    private static DishMapper dishMapper;
    @InjectMocks
    private static DishService dishService;

    @BeforeAll
    public static void setUp() {
        dishRepository = mock(DishRepositoryImpl.class);
        dishMapper = mock(DishMapper.class);
        dishService = new DishServiceImpl(dishRepository, dishMapper);
    }

    @Test
    void shouldReturnListWithCorrectSizeAndElement() {
        when(dishRepository.findAll())
                .thenReturn(List.of(getDish()));
        when(dishMapper.toEntityDto(any()))
                .thenReturn(getDishDto());

        assertEquals(1,
                dishService.findAll().size());
        assertEquals(List.of(getDishDto()),
                dishService.findAll());
    }

    @Test
    void shouldThrowExceptionIfEntityNotFoundExceptionWasThrown() {
        doThrow(new CustomEntityNotFoundException(""))
                .when(dishRepository).findById(anyLong());

        assertThrows(CustomEntityNotFoundException.class,
                () -> dishService.findById(anyLong()));
    }

    @Test
    void shouldReturnObjectWithCorrectId() {
        when(dishRepository.findById(anyLong()))
                .thenReturn(getDish());
        when(dishMapper.toEntityDto(any()))
                .thenReturn(getDishDto());

        assertEquals(0L,
                dishService.findById(0L).getId());
        assertEquals(getDishDto(),
                dishService.findById(0L));
    }
}