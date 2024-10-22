package ru.boshchenko.rtz_app.controllers.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.boshchenko.rtz_app.dto.SteelGradeDto;
import ru.boshchenko.rtz_app.model.SteelGrade;
import ru.boshchenko.rtz_app.service.interfaces.SteelGradeService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/steelgrade")
public class SteelGradeRestController {

    private final SteelGradeService steelGradeService;

    @GetMapping("/all")
    public ResponseEntity<List<SteelGradeDto>> getAllSteelGrades() {
        List<SteelGradeDto> steelGrades = steelGradeService.findAll();
        if(steelGrades.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(steelGrades, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SteelGradeDto> getSteelGradeById(@PathVariable("id") Long id) {
        if (steelGradeService.existsById(id)){
            return new ResponseEntity<>(steelGradeService.findById(id), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/creat")
    public ResponseEntity<SteelGradeDto> createSteelGrade(@RequestBody SteelGradeDto steelGradeDto) {
        steelGradeService.save(steelGradeDto);
        System.out.println("отработал стил грйед");
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


}
