package ru.boshchenko.rtz_app.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.boshchenko.rtz_app.model.TypeProduct;
import ru.boshchenko.rtz_app.service.TypeService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/typeproduct")
public class TypeProductRestController {

    private final TypeService typeService;

    @GetMapping("/all")
    public ResponseEntity<List<TypeProduct>> getAllTypeProducts() {
        List<TypeProduct> typeProducts = typeService.findAll();
        if(typeProducts.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(typeProducts, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TypeProduct> getProductById(@PathVariable("id") Long id) {
        if (typeService.existsById(id)){
            return new ResponseEntity<>(typeService.findById(id), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/creat")
    public ResponseEntity<TypeProduct> createTypeProduct(@RequestBody TypeProduct typeProduct) {
        typeService.save(typeProduct);
        System.out.println("отработал тип");
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
