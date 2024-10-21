package ru.boshchenko.rtz_app.service;

import ru.boshchenko.rtz_app.model.SteelGrade;
import ru.boshchenko.rtz_app.repository.SteelGradeRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SteelGradeServiceImpl implements SteelGradeService {

    private final SteelGradeRepo steelGradeRepo;

    @Override
    public SteelGrade save(SteelGrade steelGrade) {
        return steelGradeRepo.save(steelGrade);
    }

    @Override
    public SteelGrade findByName(String name) {
        Optional<SteelGrade> optionalSteelGrade = steelGradeRepo.findByName(name);
        //TODO сделать исключение
        if (optionalSteelGrade.isPresent()) {return optionalSteelGrade.get();}
        return null;
    }

    @Override
    public SteelGrade findById(Long id) {
        Optional<SteelGrade> optionalSteelGrade = steelGradeRepo.findById(id);
        //TODO сделать исключение
        if (optionalSteelGrade.isPresent()) {return optionalSteelGrade.get();}
        return null;
    }

    @Override
    public List<SteelGrade> findAll() {
        return steelGradeRepo.findAll();
    }

    @Override
    public boolean deleteById(Long id) {
        if (steelGradeRepo.existsById(id)) {
            steelGradeRepo.deleteById(id);
            return true;
        }return false;
    }

    @Override
    public void delete(SteelGrade steelGrade) {
        steelGradeRepo.delete(steelGrade);
    }

    @Override
    public boolean existsById(Long id) {
        return steelGradeRepo.existsById(id);
    }
}
