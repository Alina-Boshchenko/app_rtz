package ru.boshchenko.rtz_app.service.interfaces;

import ru.boshchenko.rtz_app.dto.RolledDto;
import ru.boshchenko.rtz_app.model.Rolled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RolledService {

    Rolled save(RolledDto rolledDto);

    RolledDto findByName(String name);

    Rolled findByNameRolled(String name);


    RolledDto findById(Long id);

    List<RolledDto> findAll();

    boolean deleteById(Long id);

    void delete(Rolled rolled);

    boolean existsById(Long id);

//    Rolled update(Rolled rolled);

}
