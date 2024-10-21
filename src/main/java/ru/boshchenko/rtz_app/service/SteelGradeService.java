package ru.boshchenko.rtz_app.service;

import ru.boshchenko.rtz_app.model.SteelGrade;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SteelGradeService {

    SteelGrade save(SteelGrade steelGrade);

    SteelGrade findByName(String name);

    SteelGrade findById(Long id);

    List<SteelGrade> findAll();

    boolean deleteById(Long id);

    void delete(SteelGrade steelGrade);

    boolean existsById(Long id);

}
