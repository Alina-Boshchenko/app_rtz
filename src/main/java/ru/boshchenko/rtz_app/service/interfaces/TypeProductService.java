package ru.boshchenko.rtz_app.service.interfaces;

import ru.boshchenko.rtz_app.dto.TypeProductDto;
import ru.boshchenko.rtz_app.model.TypeProduct;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TypeProductService {

    TypeProduct save(TypeProductDto typeProductDto);

    TypeProductDto findByName(String name);
    TypeProduct findByNameTypeProduct(String name);

    TypeProductDto findById(Long id);

    List<TypeProductDto> findAll();

    boolean deleteById(Long id);

    void delete(TypeProduct type);

    boolean existsById(Long id);

}
