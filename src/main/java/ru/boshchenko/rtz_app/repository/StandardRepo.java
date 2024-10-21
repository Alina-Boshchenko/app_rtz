package ru.boshchenko.rtz_app.repository;

import ru.boshchenko.rtz_app.model.Standard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StandardRepo extends JpaRepository<Standard, Long> {

    Optional<Standard> findByName(String name);

}
