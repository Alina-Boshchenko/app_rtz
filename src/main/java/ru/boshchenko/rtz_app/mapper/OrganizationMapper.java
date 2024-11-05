package ru.boshchenko.rtz_app.mapper;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import ru.boshchenko.rtz_app.dto.OrganizationDto;
import ru.boshchenko.rtz_app.model.Organization;
import ru.boshchenko.rtz_app.utils.mapper.OrganizationMapperUtil;


@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        uses = {OrganizationMapperUtil.class},
        imports = {ru.boshchenko.rtz_app.utils.mapper.OrganizationMapperUtil.class})
public interface OrganizationMapper {

    @Mapping(target = "users",
            qualifiedByName = {"OrganizationMapperUtil", "getUsers"},
            source = "usersName")
    Organization toOrganization(OrganizationDto organizationDto);

    @Mapping(target = "usersName",
            qualifiedByName = {"OrganizationMapperUtil", "getUsersName"},
            source = "users")
    OrganizationDto toOrganizationDto(Organization organization);


}