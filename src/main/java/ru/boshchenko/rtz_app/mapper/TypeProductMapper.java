package ru.boshchenko.rtz_app.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import ru.boshchenko.rtz_app.dto.TypeProductDto;
import ru.boshchenko.rtz_app.model.TypeProduct;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface TypeProductMapper {

    TypeProduct toTypeProduct(TypeProductDto typeProductDto);

    TypeProductDto toTypeProductDto(TypeProduct typeProduct);

}
