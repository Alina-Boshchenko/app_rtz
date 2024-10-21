package ru.boshchenko.rtz_app.service;

import ru.boshchenko.rtz_app.model.TypeProduct;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TypeService {

    TypeProduct save(TypeProduct type);

    TypeProduct findByName(String name);

    TypeProduct findById(Long id);

    List<TypeProduct> findAll();

    boolean deleteById(Long id);

    void delete(TypeProduct type);

    boolean existsById(Long id);

}
