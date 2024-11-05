package ru.boshchenko.rtz_app.mapper;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import ru.boshchenko.rtz_app.dto.UserDto;
import ru.boshchenko.rtz_app.model.User;
import ru.boshchenko.rtz_app.utils.mapper.UserMapperUtil;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        uses = {UserMapperUtil.class},
        imports ={ru.boshchenko.rtz_app.utils.mapper.ProductMapperUtil.class})
public interface UserMapper {

    @Mapping(target = "organizations",
            qualifiedByName = {"UserMapperUtil", "getOrganizations"},
            source = "organizationsName")
    User toUser(UserDto userDto);

    @Mapping(target = "organizationsName",
            qualifiedByName = {"UserMapperUtil", "getOrganizationsName"},
            source = "organizations")
    UserDto toUserDto(User user);

}
