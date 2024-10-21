package ru.boshchenko.rtz_app.service;

import ru.boshchenko.rtz_app.model.Rolled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RolledService {

    Rolled save(Rolled rolled);

    Rolled findByName(String name);

    Rolled findById(Long id);

    List<Rolled> findAll();

    boolean deleteById(Long id);

    void delete(Rolled rolled);

    boolean existsById(Long id);

//    Rolled update(Rolled rolled);

}
