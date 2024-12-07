package ru.boshchenko.rtz_app.repository;

import ru.boshchenko.rtz_app.model.SteelGrade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SteelGradeRepo extends JpaRepository<SteelGrade, Long> {

    Optional<SteelGrade> findByName(String name);

}
