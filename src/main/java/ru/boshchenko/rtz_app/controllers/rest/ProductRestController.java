package ru.boshchenko.rtz_app.controllers.rest;

import org.springframework.web.bind.annotation.*;
import ru.boshchenko.rtz_app.dto.ProductDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import ru.boshchenko.rtz_app.service.interfaces.ProductService;
//import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;



@RestController
@RequiredArgsConstructor
@RequestMapping("/api/product")
public class ProductRestController {

    private final ProductService productService;

//    @CrossOrigin(origins = "http://localhost:63343") // разрешение на отправку запросов с другого хоста
    @GetMapping("/all")
    public ResponseEntity<List<ProductDto>> getAllProducts() {
        List<ProductDto> products = productService.findAll();
        if (products.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        System.out.println("пришел запрос");
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDto> getProductById(@PathVariable("id") Long id) {
        if (productService.existsById(id)){
            return new ResponseEntity<>(productService.findById(id), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/creat")
    public ResponseEntity<ProductDto> createProduct(@RequestBody ProductDto productDto) {
        productService.save(productDto);
        System.out.println(productDto.toString());
        System.out.println("продукт сохранен");
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    //TODO посмотреть какой должен быть статус ответа
    @PatchMapping("/{id}")
    public ResponseEntity<ProductDto> updateProduct(@PathVariable("id") Long id, @RequestBody ProductDto productDto) {
        System.out.println(productDto);
        productService.updateById(id, productDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
