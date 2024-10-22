package ru.boshchenko.rtz_app.repository;

import ru.boshchenko.rtz_app.model.TypeProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface TypeProductRepo extends JpaRepository<TypeProduct, Long> {

    Optional<TypeProduct> findByName(String name);
}
