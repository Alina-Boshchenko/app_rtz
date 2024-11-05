package ru.boshchenko.rtz_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.boshchenko.rtz_app.model.Organization;

import java.util.Optional;


@Repository
public interface OrganizationRepo extends JpaRepository<Organization, Long> {

    Optional<Organization> findByName(String name);

    Optional<Organization> findByInn(Long inn);
}
