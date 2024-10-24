package ru.boshchenko.rtz_app.service.implementations;

import ru.boshchenko.rtz_app.dto.ProductDto;
import ru.boshchenko.rtz_app.mapper.ProductMapper;
import ru.boshchenko.rtz_app.model.Product;
import ru.boshchenko.rtz_app.repository.ProductRepo;
import ru.boshchenko.rtz_app.service.interfaces.ProductService;
import ru.boshchenko.rtz_app.utils.MappingUtilsProduct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepo productRepo;
//    private final MappingUtilsProduct mappingUtilsProduct;
    private final ProductMapper productMapper;

    @Override
    public Product save(ProductDto productDto) {
        return productRepo.save(productMapper.toProduct(productDto));
    }

    @Override
    public ProductDto findByName(String name) {
        Optional<Product> product = productRepo.findByName(name);
        //TODO сделать исключение
        if (product.isPresent()) {
            return productMapper.toProductDto(product.get());
        }
        return null;
    }

    @Override
    public ProductDto findById(Long id) {
        Optional<Product> product = productRepo.findById(id);
        //TODO сделать исключение
        if (product.isPresent()) {
            return productMapper.toProductDto(product.get());
        }
        return null;
    }

    @Override
    public List<ProductDto> findAll() {
        return productRepo.findAll().stream().map(productMapper::toProductDto).toList();
    }

    @Override
    public boolean deleteById(Long id) {
        if (productRepo.existsById(id)) {
            productRepo.deleteById(id);
            return true;
        }return false;
    }

    @Override
    public void delete(Product product) {
        productRepo.delete(product);
    }

    @Override
    public boolean existsById(Long id) {
        return productRepo.existsById(id);
    }
}
