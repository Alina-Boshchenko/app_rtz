package ru.boshchenko.rtz_app.service.implementations;

import ru.boshchenko.rtz_app.dto.ProductDto;
import ru.boshchenko.rtz_app.mapper.ProductMapper;
import ru.boshchenko.rtz_app.model.Product;
import ru.boshchenko.rtz_app.repository.ProductRepo;
import ru.boshchenko.rtz_app.service.interfaces.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepo productRepo;
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
    public void delete(ProductDto productDto) {
        productRepo.delete(productMapper.toProduct(productDto));
    }

    @Override
    public boolean existsById(Long id) {
        return productRepo.existsById(id);
    }

    @Override
    public ProductDto updateById(Long id, ProductDto productDto) {
        Product productNew = productMapper.toProduct(productDto);
        if (productRepo.findById(id).isEmpty()) {
            return null;
        }
        Product product = productRepo.findById(id).get();
        product.setRolled(productNew.getRolled());
        product.setType(productNew.getType());
        product.setName(productNew.getName());
        product.setStandard(productNew.getStandard());
        product.setSteelGrade(productNew.getSteelGrade());
        product.setSize(productNew.getSize());
        product.setLength(productNew.getLength());
        product.setThickness(productNew.getThickness());
        product.setWeight(productNew.getWeight());
        product.setPricePerMeter(productNew.getPricePerMeter());
        product.setPricePerTon(productNew.getPricePerTon());
        productRepo.save(product);
        return productMapper.toProductDto(product);
    }
}
