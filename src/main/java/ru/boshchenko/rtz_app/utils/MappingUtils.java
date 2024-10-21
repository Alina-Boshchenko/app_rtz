package ru.boshchenko.rtz_app.utils;


import lombok.RequiredArgsConstructor;
import ru.boshchenko.rtz_app.dto.ProductDto;
import ru.boshchenko.rtz_app.model.*;
import org.springframework.stereotype.Component;
import ru.boshchenko.rtz_app.service.RolledService;
import ru.boshchenko.rtz_app.service.StandardService;
import ru.boshchenko.rtz_app.service.SteelGradeService;
import ru.boshchenko.rtz_app.service.TypeService;

@Component
@RequiredArgsConstructor
public class MappingUtils {

    private final RolledService rolledService;
    private final TypeService typeService;
    private final StandardService standardService;
    private final SteelGradeService steelGradeService;


    public Product toProduct(ProductDto dto) {
        return Product.builder()
                .rolled(rolledService.findByName(dto.getRolledName()))
                .type(typeService.findByName(dto.getTypeName()))
                .name(dto.getName())
                .standard(standardService.findByName(dto.getStandardName()))
                .steelGrade(steelGradeService.findByName(dto.getSteelGradeName()))
                .size(dto.getSize())
                .length(dto.getLength())
                .thickness(dto.getThickness())
                .weight(dto.getWeight())
                .pricePerMeter(dto.getPricePerMeter())
                .pricePerTon(dto.getPricePerTon())
                .build();
    }
    public ProductDto toProductDto(Product product) {
        return ProductDto.builder()
                .rolledName(product.getRolled().getName())
                .typeName(product.getType().getName())
                .name(product.getName())
                .standardName(product.getStandard().getName())
                .steelGradeName(product.getSteelGrade().getName())
                .size(product.getSize())
                .length(product.getLength())
                .thickness(product.getThickness())
                .weight(product.getWeight())
                .pricePerMeter(product.getPricePerMeter())
                .pricePerTon(product.getPricePerTon())
                .build();
    }


}
