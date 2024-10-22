package ru.boshchenko.rtz_app.controllers.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.boshchenko.rtz_app.dto.TypeProductDto;
import ru.boshchenko.rtz_app.model.TypeProduct;
import ru.boshchenko.rtz_app.service.interfaces.TypeProductService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/typeproduct")
public class TypeProductRestController {

    private final TypeProductService typeProductService;

    @GetMapping("/all")
    public ResponseEntity<List<TypeProductDto>> getAllTypeProducts() {
        List<TypeProductDto> typeProducts = typeProductService.findAll();
        if(typeProducts.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(typeProducts, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TypeProductDto> getProductById(@PathVariable("id") Long id) {
        if (typeProductService.existsById(id)){
            return new ResponseEntity<>(typeProductService.findById(id), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/creat")
    public ResponseEntity<TypeProductDto> createTypeProduct(@RequestBody TypeProductDto typeProductDto) {
        typeProductService.save(typeProductDto);
        System.out.println("отработал тип");
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
