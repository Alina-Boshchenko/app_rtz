package ru.boshchenko.rtz_app.service;

import ru.boshchenko.rtz_app.model.Standard;
import ru.boshchenko.rtz_app.repository.StandardRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StandardServiceImpl implements StandardService {

    private final StandardRepo standardRepo;


    @Override
    public Standard save(Standard standard) {
        return standardRepo.save(standard);
    }

    @Override
    public Standard findByName(String name) {
        Optional<Standard> standard = standardRepo.findByName(name);
        //TODO сделать исключение
        if (standard.isPresent()) {
            return standard.get();
        } return null;
    }

    @Override
    public Standard findById(Long id) {
        Optional<Standard> standard = standardRepo.findById(id);
        //TODO сделать исключение
        if (standard.isPresent()) {return standard.get();}
        return null;
    }

    @Override
    public List<Standard> findAll() {
        return standardRepo.findAll();
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
