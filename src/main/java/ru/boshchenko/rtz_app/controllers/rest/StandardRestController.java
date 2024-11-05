package ru.boshchenko.rtz_app.controllers.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.boshchenko.rtz_app.dto.StandardDto;
import ru.boshchenko.rtz_app.model.Standard;
import ru.boshchenko.rtz_app.service.interfaces.StandardService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/standard")
public class StandardRestController {

    private final StandardService standardService;

    @GetMapping("/all")
    public ResponseEntity<List<StandardDto>> getAllStandards() {
        List<StandardDto> standards = standardService.findAll();
        if(standards.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(standards, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StandardDto> getStandardById(@PathVariable("id") Long id) {
        if (standardService.existsById(id)){
            return new ResponseEntity<>(standardService.findById(id), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/creat")
    public ResponseEntity<StandardDto> createStandard(@RequestBody StandardDto standardDto) {
        standardService.save(standardDto);
        System.out.println("отработал стандарт");
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    //TODO посмотреть какой должен быть статус ответа
    @PatchMapping("/{id}")
    public ResponseEntity<StandardDto> updateProduct(@PathVariable("id") Long id, @RequestBody StandardDto standardDto) {
//        System.out.println(productDto);
        if(standardService.updateStandard(id, standardDto)==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        standardService.updateStandard(id, standardDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable Long id){
        if (!standardService.deleteById(id)){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        standardService.deleteById(id);
        return new ResponseEntity<>("It's ok delete product",HttpStatus.OK);
    }


}
