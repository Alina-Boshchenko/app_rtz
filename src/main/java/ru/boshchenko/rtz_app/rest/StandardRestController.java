package ru.boshchenko.rtz_app.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.boshchenko.rtz_app.model.Standard;
import ru.boshchenko.rtz_app.service.StandardService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/standard")
public class StandardRestController {

    private final StandardService standardService;

    @GetMapping("/all")
    public ResponseEntity<List<Standard>> getAllStandards() {
        List<Standard> standards = standardService.findAll();
        if(standards.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(standards, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Standard> getStandardById(@PathVariable("id") Long id) {
        if (standardService.existsById(id)){
            return new ResponseEntity<>(standardService.findById(id), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/creat")
    public ResponseEntity<Standard> createStandard(@RequestBody Standard standard) {
        standardService.save(standard);
        System.out.println("отработал стандарт");
        return new ResponseEntity<>(HttpStatus.CREATED);
    }



}
