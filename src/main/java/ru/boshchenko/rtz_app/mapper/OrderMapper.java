package ru.boshchenko.rtz_app.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import ru.boshchenko.rtz_app.dto.OrderDto;
import ru.boshchenko.rtz_app.model.Order;
import ru.boshchenko.rtz_app.utils.mapper.OrderMapperUtil;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
uses = {OrderMapperUtil.class},
imports = {ru.boshchenko.rtz_app.utils.mapper.OrderMapperUtil.class})
public interface OrderMapper {

    @Mapping(target = "products",
    qualifiedByName = {"OrderMapperUtil", "getProducts"},
    source = "idProducts")
    @Mapping(target = "user",
            qualifiedByName = {"OrderMapperUtil", "getUser"},
            source = "userId")
    Order toOrder(OrderDto orderDto);

    @Mapping(target = "idProducts",
            qualifiedByName = {"OrderMapperUtil", "getIdProducts"},
            source = "products")
    @Mapping(target = "userId",
            qualifiedByName = {"OrderMapperUtil", "getUserId"},
            source = "user")
    OrderDto toOrderDto(Order order);
}
