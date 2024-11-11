package ru.boshchenko.rtz_app.utils.mapper;


import lombok.RequiredArgsConstructor;
import org.mapstruct.Named;
import org.springframework.stereotype.Component;
import ru.boshchenko.rtz_app.model.Organization;
import ru.boshchenko.rtz_app.service.interfaces.OrganizationService;

import java.util.Collection;

@Named("UserMapperUtil")
@Component
@RequiredArgsConstructor
public class UserMapperUtil {

    private final OrganizationService organizationService;

    @Named("getOrganizationsName")
    public Collection<String> getOrganizationsName(Collection<Organization> organizations){
        return organizations.stream().map(Organization::getName).toList();
    }

    @Named("getOrganizations")
    public Collection<Organization> getOrganizations(Collection<String> organizationsName){
        return organizationsName.stream().map(organizationService::findByName).toList();
    }


}
