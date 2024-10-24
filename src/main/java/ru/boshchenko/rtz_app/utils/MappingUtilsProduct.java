package ru.boshchenko.rtz_app.utils;


import lombok.RequiredArgsConstructor;
import ru.boshchenko.rtz_app.dto.*;
import ru.boshchenko.rtz_app.model.*;
import org.springframework.stereotype.Component;
import ru.boshchenko.rtz_app.service.interfaces.RolledService;
import ru.boshchenko.rtz_app.service.interfaces.StandardService;
import ru.boshchenko.rtz_app.service.interfaces.SteelGradeService;
import ru.boshchenko.rtz_app.service.interfaces.TypeProductService;

@Component
@RequiredArgsConstructor
public class MappingUtilsProduct {

//    private final RolledService rolledService;
//    private final TypeProductService typeProductService;
//    private final StandardService standardService;
//    private final SteelGradeService steelGradeService;
//
//
//    public Product toProduct(ProductDto dto) {
//        return Product.builder()
//                .rolled(rolledService.findByNameRolled(dto.getRolledName()))
//                .type(typeProductService.findByNameTypeProduct(dto.getTypeName()))
//                .name(dto.getName())
//                .standard(standardService.findByNameStandard(dto.getStandardName()))
//                .steelGrade(steelGradeService.findByNameSteelGrade(dto.getSteelGradeName()))
//                .size(dto.getSize())
//                .length(dto.getLength())
//                .thickness(dto.getThickness())
//                .weight(dto.getWeight())
//                .pricePerMeter(dto.getPricePerMeter())
//                .pricePerTon(dto.getPricePerTon())
//                .build();
//    }
//    public ProductDto toProductDto(Product product) {
//        return ProductDto.builder()
//                .rolledName(product.getRolled().getName())
//                .typeName(product.getType().getName())
//                .name(product.getName())
//                .standardName(product.getStandard().getName())
//                .steelGradeName(product.getSteelGrade().getName())
//                .size(product.getSize())
//                .length(product.getLength())
//                .thickness(product.getThickness())
//                .weight(product.getWeight())
//                .pricePerMeter(product.getPricePerMeter())
//                .pricePerTon(product.getPricePerTon())
//                .build();
//    }
//






}
