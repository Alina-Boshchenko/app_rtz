package ru.boshchenko.rtz_app.service.interfaces;

import ru.boshchenko.rtz_app.dto.ProductDto;
import ru.boshchenko.rtz_app.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {

    Product save(ProductDto productDto);

    ProductDto findByName(String name);

    ProductDto findById(Long id);

    List<ProductDto> findAll();

    boolean deleteById(Long id);

    void delete(Product product);

    boolean existsById(Long id);

    ProductDto updateById(Long id, ProductDto productDto);

}
