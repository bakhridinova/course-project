package com.epam.uni.util.mapper;

import com.epam.uni.config.TestConfig;
import com.epam.uni.dto.LinenDto;
import com.epam.uni.entity.Linen;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static com.epam.uni.data.TestDataStorage.getLinen;
import static com.epam.uni.data.TestDataStorage.getLinenDto;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = TestConfig.class)
class LinenMapperTest {
    @Autowired
    private BaseMapper<Linen, LinenDto> linenMapper;

    @Test
    void shouldMapLinensCorrectlyTest() {
        assertEquals(getLinen(),
                linenMapper.toEntity(getLinenDto()));
        assertEquals(getLinenDto(),
                linenMapper.toEntityDto(getLinen()));
    }

    @Test
    void shouldReturnNullIfNullPassedTest() {
        assertNull(linenMapper.toEntity(null));
        assertNull(linenMapper.toEntityDto(null));
    }

    @Test
    void shouldReturnNullObjectIfNullObjectPassedTest() {
        Linen linen = Linen.builder().build();
        LinenDto linenDto = LinenDto.builder().build();

        assertEquals(linen,
                linenMapper.toEntity(linenDto));
        assertEquals(linenDto,
                linenMapper.toEntityDto(linen));
    }
}