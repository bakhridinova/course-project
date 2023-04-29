package com.epam.uni.util.mapper;

import com.epam.uni.dto.LinenDto;
import com.epam.uni.entity.Linen;
import org.mapstruct.Mapper;

/**
 * mapper converting linen to linen dto and vice versa
 *
 * @author bakhridinova
 */

@Mapper(componentModel = "spring")
public interface LinenMapper {
    Linen toLinen(LinenDto linen);
    LinenDto toLinenDto(Linen linen);
}
