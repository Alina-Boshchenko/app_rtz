package ru.boshchenko.rtz_app.utils.mapper;


import lombok.RequiredArgsConstructor;
import org.mapstruct.Named;
import org.springframework.stereotype.Component;
import ru.boshchenko.rtz_app.model.Organization;
import ru.boshchenko.rtz_app.service.interfaces.OrganizationService;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Named("UserMapperUtil")
@Component
@RequiredArgsConstructor
public class UserMapperUtil {

    private final OrganizationService organizationService;

    @Named("getOrganizationsName")
    public Collection<String> getOrganizationsName(Collection<Organization> organizations){
        return organizations.stream().map(o -> o.getName()).toList();
    }

    @Named("getOrganizations")
    public Collection<Organization> getOrganizations(Collection<String> organizationsName){
        return organizationsName.stream().map(o -> organizationService.findByName(o)).toList();
    }


}
