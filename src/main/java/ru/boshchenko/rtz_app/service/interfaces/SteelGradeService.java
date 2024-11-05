package ru.boshchenko.rtz_app.service.interfaces;

import ru.boshchenko.rtz_app.dto.SteelGradeDto;
import ru.boshchenko.rtz_app.model.SteelGrade;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SteelGradeService {

    SteelGrade save(SteelGradeDto steelGradeDto);

    SteelGradeDto findByName(String name);
    SteelGrade findByNameSteelGrade(String name);


    SteelGradeDto findById(Long id);

    List<SteelGradeDto> findAll();

    boolean deleteById(Long id);

    void delete(SteelGradeDto steelGradeDto);

    boolean existsById(Long id);


    SteelGradeDto updateSteelGrade(Long id, SteelGradeDto steelGradeDto);

}
