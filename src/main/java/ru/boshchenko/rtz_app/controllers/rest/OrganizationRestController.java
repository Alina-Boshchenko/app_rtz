package ru.boshchenko.rtz_app.controllers.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.boshchenko.rtz_app.dto.OrganizationDto;
import ru.boshchenko.rtz_app.dto.ProductDto;
import ru.boshchenko.rtz_app.service.interfaces.OrganizationService;

import java.util.List;

@RestController
@RequestMapping("/api/organization")
@RequiredArgsConstructor
public class OrganizationRestController {

    private final OrganizationService organizationService;

    @GetMapping("/all")
    public ResponseEntity<List<OrganizationDto>> getAllOrganizations() {
        List<OrganizationDto> organizations = organizationService.findAll();
        if (organizations.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(organizations, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrganizationDto> getOrganizationById(@PathVariable("id") Long id) {
        if (organizationService.existsById(id)) {
            return new ResponseEntity<>(organizationService.findById(id), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/create")
    public ResponseEntity<ProductDto> createOrganization(@RequestBody OrganizationDto organizationDto) {
        organizationService.save(organizationDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<OrganizationDto> updateOrganization(@PathVariable("id") Long id, @RequestBody OrganizationDto organizationDto) {
        if (organizationService.updateOrganization(id, organizationDto) == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        organizationService.updateOrganization(id, organizationDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteOrganization(@PathVariable Long id) {
        if (!organizationService.deleteById(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        organizationService.deleteById(id);
        return new ResponseEntity<>("It's ok delete product", HttpStatus.OK);
    }

}
