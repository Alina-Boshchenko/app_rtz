package ru.boshchenko.rtz_app.repository;

import ru.boshchenko.rtz_app.model.Rolled;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RolledRepo extends JpaRepository<Rolled, Long> {

    Optional<Rolled> findByName(String name);

//    Optional<Rolled> update(Rolled rolled);

}
