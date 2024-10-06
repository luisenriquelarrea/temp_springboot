package com.artplusplus.contpp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.artplusplus.contpp.dto.AccionDto;
import com.artplusplus.contpp.model.Accion;
import com.artplusplus.contpp.repository.specifications.AccionSpecifications;
import com.artplusplus.contpp.service.AccionService;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController // This means that this class is a Controller
@RequestMapping(path="/api/accion") // This means URL's start with / (after Application path)
public class AccionController {
    @Autowired
    private AccionService accionService;

    @PostMapping(path="/add") // Map ONLY POST Requests
    public ResponseEntity<Accion> add(@RequestBody Accion accion) {
        // @ResponseBody means the returned Entity is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request
        Accion obj = accionService.save(accion);
        return ResponseEntity.ok(obj);
    }

    @PutMapping(path="/{id}")
    public ResponseEntity<Accion> update(@RequestBody Accion accion,
                     @PathVariable Long id){
        Accion obj = accionService.save(accion);
        return ResponseEntity.ok(obj);
    }

    @GetMapping(path="/")
    public @ResponseBody List<Accion> all() {
        // This returns a JSON or XML
        return accionService.list();
    }

    @DeleteMapping(path="/{id}")
    public ResponseEntity<String> deleteById(@PathVariable String id) {
        Long accionId = Long.parseLong(id);
        if(accionService.existsById(accionId)){
            accionService.deleteById(accionId);
            return ResponseEntity.ok("Deleted");
        }
        return ResponseEntity.ok("ID not found");
    }

    @GetMapping(path="/{id}")
    public ResponseEntity<Accion> getById(@PathVariable Long id){
        if(accionService.existsById(id)){
            Accion accion = accionService.getById(id);
            return ResponseEntity.ok(accion);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping(path="/filteredList") // Map ONLY POST Requests
    public @ResponseBody List<AccionDto> filteredList(@RequestBody AccionDto accionDto) {
        // @ResponseBody means the returned Entity is the response, not a view name
        Specification<Accion> specs = new AccionSpecifications(accionDto);
        int offset = accionDto.getOffset();
        int limit = accionDto.getLimit();
        int page = offset / limit;
        return accionService.filteredList(specs, PageRequest.of(page, limit));
    }

    @GetMapping(path="/count")
    public ResponseEntity<Long> count() {
        return ResponseEntity.ok(accionService.count());
    }

    @PostMapping(path="/countFilteredList")
    public ResponseEntity<Long> countFilteredList(@RequestBody AccionDto accionDto) {
        Specification<Accion> specs = new AccionSpecifications(accionDto);
        return ResponseEntity.ok(accionService.countFilteredList(specs));
    }
}
