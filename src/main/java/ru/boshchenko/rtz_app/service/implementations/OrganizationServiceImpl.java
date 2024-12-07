package ru.boshchenko.rtz_app.service.implementations;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import ru.boshchenko.rtz_app.dto.OrganizationDto;
import ru.boshchenko.rtz_app.mapper.OrganizationMapper;
import ru.boshchenko.rtz_app.model.Organization;
import ru.boshchenko.rtz_app.repository.OrganizationRepo;
import ru.boshchenko.rtz_app.service.interfaces.OrganizationService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrganizationServiceImpl implements OrganizationService {

    private final OrganizationRepo organizationRepo;
    private final OrganizationMapper organizationMapper;

    @Override
    public Organization save(OrganizationDto organizationDto) {
        return organizationRepo.save(organizationMapper.toOrganization(organizationDto));
    }

    @Override
    public OrganizationDto findByNameDto(String name) {
        //TODO сделать исключение
        return organizationMapper.toOrganizationDto(organizationRepo.findByName(name).orElse(null));
    }

    @Override
    public Organization findByName(String name) {
        return organizationRepo.findByName(name).orElse(null);
    }

    @Override
    public OrganizationDto findByInn(Long inn) {
        //TODO сделать исключение
        return organizationMapper.toOrganizationDto(organizationRepo.findByInn(inn).orElse(null));
    }

    @Override
    public OrganizationDto findById(Long id) {
        //TODO сделать исключение
        return organizationMapper.toOrganizationDto(organizationRepo.findById(id).orElse(null));
    }

    @Override
    public List<OrganizationDto> findAll() {
        return organizationRepo.findAll().stream().map(o -> organizationMapper.toOrganizationDto(o)).toList();
    }

    @Override
    public boolean deleteById(Long id) {
        if (organizationRepo.existsById(id)) {
            organizationRepo.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public void delete(OrganizationDto organizationDto) {
        organizationRepo.delete(organizationMapper.toOrganization(organizationDto));
    }

    @Override
    public boolean existsById(Long id) {
        return organizationRepo.existsById(id);
    }

    @Override
    public OrganizationDto updateOrganization(Long id, OrganizationDto organizationDto) {
        Organization organizationNew = organizationMapper.toOrganization(organizationDto);
        if (organizationRepo.findById(id).isEmpty()) {
            return null;
        }
        Organization organization = organizationRepo.findById(id).get();
        organization.setName(organizationNew.getName());
        organization.setLegalAddress(organizationNew.getLegalAddress());
        organization.setOgrn(organizationNew.getOgrn());
        organization.setInn(organizationNew.getInn());
        organization.setKpp(organizationNew.getKpp());
        organization.setBICBank(organizationNew.getBICBank());
        organization.setBankNames(organizationNew.getBankNames());
        organization.setPaymentAccount(organizationNew.getPaymentAccount());
        organizationRepo.save(organization);
        return organizationMapper.toOrganizationDto(organization);
    }

}

