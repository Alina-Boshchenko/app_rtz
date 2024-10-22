package ru.boshchenko.rtz_app.service.interfaces;

import org.springframework.stereotype.Service;
import ru.boshchenko.rtz_app.model.Organization;

import java.util.List;

@Service
public interface OrganizationService {

    Organization save(Organization organization);

    Organization findByName(String name);

    /**
     * @param inn - ИНН организации
     * @return сущность записи в БД
     */
    Organization findByInn(Long inn);

    Organization findById(Long id);

    List<Organization> findAll();

    boolean deleteById(Long id);

    void delete(Organization organization);

    boolean existsById(Long id);

}
