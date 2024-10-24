package ru.boshchenko.rtz_app.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import ru.boshchenko.rtz_app.dto.ProductDto;
import ru.boshchenko.rtz_app.model.Product;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ProductMapper {

    Product toProduct(ProductDto productDto);

    ProductDto toProductDto(Product product);
}
