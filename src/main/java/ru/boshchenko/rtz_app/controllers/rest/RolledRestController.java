package ru.boshchenko.rtz_app.controllers.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.boshchenko.rtz_app.dto.RolledDto;
import ru.boshchenko.rtz_app.model.Rolled;
import ru.boshchenko.rtz_app.service.interfaces.RolledService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/rolled")
public class RolledRestController {


    private final RolledService rolledService;

    @GetMapping("/all")
    public ResponseEntity<List<RolledDto>> getAllRolleds() {
        List<RolledDto> rolleds = rolledService.findAll();
        if(rolleds.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(rolleds, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RolledDto> getRolledById(@PathVariable("id") Long id) {
        if (rolledService.existsById(id)){
            return new ResponseEntity<>(rolledService.findById(id), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/creat")
    public ResponseEntity<RolledDto> createRolled(@RequestBody RolledDto rolledDto) {
        rolledService.save(rolledDto);
        System.out.println("отработал прокат");
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
