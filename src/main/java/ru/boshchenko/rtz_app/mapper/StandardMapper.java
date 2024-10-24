package ru.boshchenko.rtz_app.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import ru.boshchenko.rtz_app.dto.StandardDto;
import ru.boshchenko.rtz_app.model.Standard;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface StandardMapper {

    Standard toStandard(StandardDto standardDto);
    StandardDto toStandardDto(Standard standard);
}
