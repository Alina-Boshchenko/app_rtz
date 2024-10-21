package ru.boshchenko.rtz_app.service;

import ru.boshchenko.rtz_app.model.TypeProduct;
import ru.boshchenko.rtz_app.repository.TypeRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TypeServiceImpl implements TypeService {

    private final TypeRepo typeRepo;

    @Override
    public TypeProduct save(TypeProduct type) {
        return typeRepo.save(type);
    }

    @Override
    public TypeProduct findByName(String name) {
        Optional<TypeProduct> type = typeRepo.findByName(name);
        //TODO сделать исключение
        if (type.isPresent()) {return type.get();}
        return null;
    }

    @Override
    public TypeProduct findById(Long id) {
        Optional<TypeProduct> type = typeRepo.findById(id);
        //TODO сделать исключение
        if (type.isPresent()) {return type.get();}
        return null;
    }

    @Override
    public List<TypeProduct> findAll() {
        return typeRepo.findAll();
    }

    @Override
    public boolean deleteById(Long id) {
        if (typeRepo.existsById(id)) {
            typeRepo.deleteById(id);
            return true;
        }return false;
    }

    @Override
    public void delete(TypeProduct type) {
typeRepo.delete(type);
    }

    @Override
    public boolean existsById(Long id) {
        return typeRepo.existsById(id);
    }
}
