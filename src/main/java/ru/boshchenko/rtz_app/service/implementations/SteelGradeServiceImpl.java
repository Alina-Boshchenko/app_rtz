package ru.boshchenko.rtz_app.service.implementations;

import ru.boshchenko.rtz_app.dto.SteelGradeDto;
import ru.boshchenko.rtz_app.mapper.SteelGradeMapper;
import ru.boshchenko.rtz_app.model.SteelGrade;
import ru.boshchenko.rtz_app.repository.SteelGradeRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.boshchenko.rtz_app.service.interfaces.SteelGradeService;
import ru.boshchenko.rtz_app.utils.MappingUtilsSteelGrade;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SteelGradeServiceImpl implements SteelGradeService {

    private final SteelGradeRepo steelGradeRepo;
//    private final MappingUtilsSteelGrade mappingUtilsSteelGrade;
    private final SteelGradeMapper steelGradeMapper;

    @Override
    public SteelGrade save(SteelGradeDto steelGradeDto) {
        return steelGradeRepo.save(steelGradeMapper.toSteelGrade(steelGradeDto));
    }

    @Override
    public SteelGradeDto findByName(String name) {
        Optional<SteelGrade> optionalSteelGrade = steelGradeRepo.findByName(name);
        //TODO сделать исключение
        if (optionalSteelGrade.isPresent()) {return steelGradeMapper.toSteelGradeDto(optionalSteelGrade.get());}
        return null;
    }

    @Override
    public SteelGrade findByNameSteelGrade(String name) {
        return steelGradeRepo.findByName(name).orElse(null);
    }

    @Override
    public SteelGradeDto findById(Long id) {
        Optional<SteelGrade> optionalSteelGrade = steelGradeRepo.findById(id);
        //TODO сделать исключение
        if (optionalSteelGrade.isPresent()) {return steelGradeMapper.toSteelGradeDto(optionalSteelGrade.get());}
        return null;
    }

    @Override
    public List<SteelGradeDto> findAll() {
        return steelGradeRepo.findAll().stream().map(steelGradeMapper::toSteelGradeDto).toList();
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
