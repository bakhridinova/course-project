package com.epam.uni.util.mapper;

import com.epam.uni.dto.LinenDto;
import com.epam.uni.entity.Linen;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LinenMapper extends BaseMapper<Linen, LinenDto> {

}
