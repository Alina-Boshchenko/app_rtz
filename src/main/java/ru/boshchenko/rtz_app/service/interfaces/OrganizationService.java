package ru.boshchenko.rtz_app.service.interfaces;

import org.springframework.stereotype.Service;
import ru.boshchenko.rtz_app.dto.OrganizationDto;
import ru.boshchenko.rtz_app.model.Organization;

import java.util.List;

@Service
public interface OrganizationService {

    Organization save(OrganizationDto organizationDto);

    OrganizationDto findByNameDto(String name);

    Organization findByName(String name);

    /**
     * @param inn - ИНН организации
     * @return сущность записи в БД
     */
    OrganizationDto findByInn(Long inn);

    OrganizationDto findById(Long id);

    List<OrganizationDto> findAll();

    boolean deleteById(Long id);

    void delete(OrganizationDto organizationDto);

    boolean existsById(Long id);

    OrganizationDto updateOrganization(Long id, OrganizationDto organizationDto);

}
