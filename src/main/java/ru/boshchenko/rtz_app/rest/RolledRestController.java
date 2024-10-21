package ru.boshchenko.rtz_app.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.boshchenko.rtz_app.model.Rolled;
import ru.boshchenko.rtz_app.service.RolledService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/rolled")
public class RolledRestController {


    private final RolledService rolledService;

    @GetMapping("/all")
    public ResponseEntity<List<Rolled>> getAllRolleds() {
        List<Rolled> rolleds = rolledService.findAll();
        if(rolleds.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(rolleds, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Rolled> getRolledById(@PathVariable("id") Long id) {
        if (rolledService.existsById(id)){
            return new ResponseEntity<>(rolledService.findById(id), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/creat")
    public ResponseEntity<Rolled> createRolled(@RequestBody Rolled rolled) {
        rolledService.save(rolled);
        System.out.println(rolled.getName());
        System.out.println("отработал прокат");
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
