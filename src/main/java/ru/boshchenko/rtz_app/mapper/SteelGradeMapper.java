package ru.boshchenko.rtz_app.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import ru.boshchenko.rtz_app.dto.SteelGradeDto;
import ru.boshchenko.rtz_app.model.SteelGrade;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface SteelGradeMapper {

    SteelGrade toSteelGrade(SteelGradeDto steelGradeDto);

    SteelGradeDto toSteelGradeDto(SteelGrade steelGrade);

}
