package ru.boshchenko.rtz_app.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import ru.boshchenko.rtz_app.dto.ProductDto;
import ru.boshchenko.rtz_app.model.Product;
import ru.boshchenko.rtz_app.utils.mapper.ProductMapperUtil;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
uses = {ProductMapperUtil.class},
imports = {ru.boshchenko.rtz_app.utils.mapper.ProductMapperUtil.class})
public interface ProductMapper {

    @Mapping(target = "rolled",
            qualifiedByName = {"ProductMapperUtil", "detRolledByName"},
    source = "rolledName")
    @Mapping(target = "type",
    qualifiedByName = {"ProductMapperUtil", "getTypeProductByName"},
    source = "typeName")
    @Mapping(target = "standard",
            qualifiedByName = {"ProductMapperUtil", "getStandardByName"},
            source = "standardName")
    @Mapping(target = "steelGrade",
            qualifiedByName = {"ProductMapperUtil", "getSteelGradeByName"},
            source = "steelGradeName")
    Product toProduct(ProductDto productDto);


    @Mapping(target = "rolledName",
    qualifiedByName = {"ProductMapperUtil", "getNameRolled"},
    source = "rolled")
    @Mapping(target = "typeName",
    qualifiedByName = {"ProductMapperUtil", "getNameTypeProduct"},
    source = "type")
    @Mapping(target = "standardName",
    qualifiedByName = {"ProductMapperUtil", "getNameStandard"},
    source = "standard")
    @Mapping(target = "steelGradeName",
    qualifiedByName = {"ProductMapperUtil", "getNameSteelGrade"},
    source = "steelGrade")
    ProductDto toProductDto(Product product);


}

