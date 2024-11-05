package ru.boshchenko.rtz_app.service.interfaces;

import ru.boshchenko.rtz_app.dto.StandardDto;
import ru.boshchenko.rtz_app.model.Standard;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StandardService {

    Standard save(StandardDto standardDto);

    StandardDto findByName(String name);

    Standard findByNameStandard(String name);

    StandardDto findById(Long id);

    List<StandardDto> findAll();

    boolean deleteById(Long id);

    void delete(StandardDto standardDto);

    boolean existsById(Long id);

    StandardDto updateStandard(Long id, StandardDto standardDto);


}
