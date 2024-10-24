package ru.boshchenko.rtz_app.service.implementations;

import ru.boshchenko.rtz_app.dto.StandardDto;
import ru.boshchenko.rtz_app.mapper.StandardMapper;
import ru.boshchenko.rtz_app.model.Standard;
import ru.boshchenko.rtz_app.repository.StandardRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.boshchenko.rtz_app.service.interfaces.StandardService;
import ru.boshchenko.rtz_app.utils.MappingUtilsStandard;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StandardServiceImpl implements StandardService {

    private final StandardRepo standardRepo;
//    private final MappingUtilsStandard mappingUtilsStandard;
    private final StandardMapper standardMapper;


    @Override
    public Standard save(StandardDto standardDto) {
        return standardRepo.save(standardMapper.toStandard(standardDto));
    }

    @Override
    public StandardDto findByName(String name) {
        Optional<Standard> standard = standardRepo.findByName(name);
        //TODO сделать исключение
        if (standard.isPresent()) {
            return standardMapper.toStandardDto(standard.get());
        } return null;
    }

    @Override
    public Standard findByNameStandard(String name) {
        return standardRepo.findByName(name).orElse(null);
    }

    @Override
    public StandardDto findById(Long id) {
        Optional<Standard> standard = standardRepo.findById(id);
        //TODO сделать исключение
        if (standard.isPresent()) {return standardMapper.toStandardDto(standard.get());}
        return null;
    }

    @Override
    public List<StandardDto> findAll() {
        return standardRepo.findAll().stream().map(standardMapper::toStandardDto).toList();
    }

    @Override
    public boolean deleteById(Long id) {
        if(standardRepo.existsById(id)){
            standardRepo.deleteById(id);
            return true;
        } return false;
    }

    @Override
    public void delete(Standard standard) {
        standardRepo.delete(standard);
    }

    @Override
    public boolean existsById(Long id) {
        return standardRepo.existsById(id);
    }
}
