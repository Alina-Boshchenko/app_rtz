package ru.boshchenko.rtz_app.rest;

import jakarta.transaction.Transactional;
import org.springframework.web.bind.annotation.*;
import ru.boshchenko.rtz_app.dto.ProductDto;
import ru.boshchenko.rtz_app.model.*;
import ru.boshchenko.rtz_app.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

//    @CrossOrigin(origins = "http://localhost:63343")
//    @GetMapping
//    public void creatTest(){
//        Rolled rolled = new Rolled("прокат");
//        Standard standard = new Standard("стандарт");
//        SteelGrade steelGrade = new SteelGrade("марка стали");
//        TypeProduct type = new TypeProduct("тип");
//        Product product = new Product(rolled,type,"Имя турбы",standard,steelGrade,
//                "Размер турбы",5.5,56.2,5000.00,
//                700.00,800000.00);
//        rolledService.save(rolled);
//        standardService.save(standard);
//        steelGradeService.save(steelGrade);
//        typeService.save(type);
//        productService.save(product);
//        rolled.setProducts(List.of(product));
//        standard.setProducts(List.of(product));
//        steelGrade.setProducts(List.of(product));
//        type.setProducts(List.of(product));
//        System.out.println("отработал");
//
//    }

    @PostMapping("/creat")

    public ResponseEntity<ProductDto> createProduct(@RequestBody ProductDto productDto) {
        productService.save(productDto);
        System.out.println(productDto.toString());
        System.out.println("продукт сохранен");
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
