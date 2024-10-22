package ru.boshchenko.rtz_app.service.implementations;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.boshchenko.rtz_app.model.Organization;
import ru.boshchenko.rtz_app.repository.OrganizationRepo;
import ru.boshchenko.rtz_app.service.interfaces.OrganizationService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrganizationServiceImpl implements OrganizationService {

    private final OrganizationRepo organizationRepo;

    @Override
    public Organization save(Organization organization) {
        return organizationRepo.save(organization);
    }

    @Override
    public Organization findByName(String name) {
        //TODO сделать исключение
        return organizationRepo.findByName(name).orElse(null);
    }

    @Override
    public Organization findByInn(Long inn) {
        //TODO сделать исключение
        return organizationRepo.findByInn(inn).orElse(null);
    }

    @Override
    public Organization findById(Long id) {
        //TODO сделать исключение
        return organizationRepo.findById(id).orElse(null);
    }

    @Override
    public List<Organization> findAll() {
        return organizationRepo.findAll();
    }

    @Override
    public boolean deleteById(Long id) {
        if(organizationRepo.existsById(id)){
            organizationRepo.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public void delete(Organization organization) {
        organizationRepo.delete(organization);
    }

    @Override
    public boolean existsById(Long id) {
        return organizationRepo.existsById(id);
    }

}
