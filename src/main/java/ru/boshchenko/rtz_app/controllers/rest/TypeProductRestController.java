package ru.boshchenko.rtz_app.controllers.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.boshchenko.rtz_app.dto.TypeProductDto;
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
        if (typeProducts.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(typeProducts, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TypeProductDto> getProductById(@PathVariable("id") Long id) {
        if (typeProductService.existsById(id)) {
            return new ResponseEntity<>(typeProductService.findById(id), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/create")
    public ResponseEntity<TypeProductDto> createTypeProduct(@RequestBody TypeProductDto typeProductDto) {
        typeProductService.save(typeProductDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<TypeProductDto> updateProduct(@PathVariable("id") Long id, @RequestBody TypeProductDto typeProductDto) {
        if (typeProductService.updateTypeProduct(id, typeProductDto) == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        typeProductService.updateTypeProduct(id, typeProductDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable Long id) {
        if (!typeProductService.deleteById(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        typeProductService.deleteById(id);
        return new ResponseEntity<>("It's ok delete product", HttpStatus.OK);
    }

}
