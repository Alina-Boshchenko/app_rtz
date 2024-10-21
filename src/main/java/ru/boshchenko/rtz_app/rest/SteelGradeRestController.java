package ru.boshchenko.rtz_app.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.boshchenko.rtz_app.model.SteelGrade;
import ru.boshchenko.rtz_app.service.SteelGradeService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/steelgrade")
public class SteelGradeRestController {

    private final SteelGradeService steelGradeService;

    @GetMapping("/all")
    public ResponseEntity<List<SteelGrade>> getAllSteelGrades() {
        List<SteelGrade> steelGrades = steelGradeService.findAll();
        if(steelGrades.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(steelGrades, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SteelGrade> getSteelGradeById(@PathVariable("id") Long id) {
        if (steelGradeService.existsById(id)){
            return new ResponseEntity<>(steelGradeService.findById(id), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/creat")
    public ResponseEntity<SteelGrade> createSteelGrade(@RequestBody SteelGrade steelGrade) {
        steelGradeService.save(steelGrade);
        System.out.println("отработал стил грйед");
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


}
