package ru.boshchenko.rtz_app.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import ru.boshchenko.rtz_app.dto.RolledDto;
import ru.boshchenko.rtz_app.model.Rolled;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface RolledMapper {

    Rolled toRolled(RolledDto rolledDto);
    RolledDto toRolledDto(Rolled rolled);
}
