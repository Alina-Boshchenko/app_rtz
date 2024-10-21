package ru.boshchenko.rtz_app.service;

import ru.boshchenko.rtz_app.model.Standard;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StandardService {

    Standard save(Standard standard);

    Standard findByName(String name);

    Standard findById(Long id);

    List<Standard> findAll();

    boolean deleteById(Long id);

    void delete(Standard standard);

    boolean existsById(Long id);


}
