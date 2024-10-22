package ru.boshchenko.rtz_app.service.implementations;

import ru.boshchenko.rtz_app.dto.TypeProductDto;
import ru.boshchenko.rtz_app.model.TypeProduct;
import ru.boshchenko.rtz_app.repository.TypeProductRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.boshchenko.rtz_app.service.interfaces.TypeProductService;
import ru.boshchenko.rtz_app.utils.MappingUtilsTypeProduct;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TypeProductServiceImpl implements TypeProductService {

    private final TypeProductRepo typeRepo;
    private final MappingUtilsTypeProduct mappingUtilsTypeProduct;

    @Override
    public TypeProduct save(TypeProductDto typeProductDto) {
        return typeRepo.save(mappingUtilsTypeProduct.toTypeProduct(typeProductDto));
    }

    @Override
    public TypeProductDto findByName(String name) {
        Optional<TypeProduct> type = typeRepo.findByName(name);
        //TODO сделать исключение
        if (type.isPresent()) {return mappingUtilsTypeProduct.toTypeProductDto(type.get());}
        return null;
    }

    @Override
    public TypeProduct findByNameTypeProduct(String name) {
        return typeRepo.findByName(name).orElse(null);
    }

    @Override
    public TypeProductDto findById(Long id) {
        Optional<TypeProduct> type = typeRepo.findById(id);
        //TODO сделать исключение
        if (type.isPresent()) {return mappingUtilsTypeProduct.toTypeProductDto(type.get());}
        return null;
    }

    @Override
    public List<TypeProductDto> findAll() {
        return typeRepo.findAll().stream().map(mappingUtilsTypeProduct::toTypeProductDto).toList();
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
