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

import com.artplusplus.contpp.dto.GrupoDto;
import com.artplusplus.contpp.model.Grupo;
import com.artplusplus.contpp.specifications.GrupoSpecifications;
import com.artplusplus.contpp.service.GrupoService;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController // This means that this class is a Controller
@RequestMapping(path="/api/grupo") // This means URL's start with / (after Application path)
public class GrupoController {
    @Autowired
    private GrupoService grupoService;

    @PostMapping(path="/add") // Map ONLY POST Requests
    public ResponseEntity<Grupo> add(@RequestBody Grupo grupo) {
        // @ResponseBody means the returned Entity is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request
        Grupo obj = grupoService.save(grupo);
        return ResponseEntity.ok(obj);
    }

    @PutMapping(path="/{id}")
    public ResponseEntity<Grupo> update(@RequestBody Grupo grupo,
                     @PathVariable Long id){
        Grupo obj = grupoService.save(grupo);
        return ResponseEntity.ok(obj);
    }

    @GetMapping(path="/")
    public @ResponseBody List<Grupo> all() {
        // This returns a JSON or XML
        return grupoService.list();
    }

    @DeleteMapping(path="/{id}")
    public ResponseEntity<String> deleteById(@PathVariable String id) {
        Long grupoId = Long.parseLong(id);
        if(grupoService.existsById(grupoId)){
            grupoService.deleteById(grupoId);
            return ResponseEntity.ok("Deleted");
        }
        return ResponseEntity.ok("ID not found");
    }

    @GetMapping(path="/{id}")
    public ResponseEntity<Grupo> getById(@PathVariable Long id){
        if(grupoService.existsById(id)){
            Grupo grupo = grupoService.getById(id);
            return ResponseEntity.ok(grupo);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping(path="/filteredList") // Map ONLY POST Requests
    public @ResponseBody List<GrupoDto> filteredList(@RequestBody GrupoDto grupoDto) {
        // @ResponseBody means the returned Entity is the response, not a view name
        Specification<Grupo> specs = new GrupoSpecifications(grupoDto);
        int offset = grupoDto.getOffset();
        int limit = grupoDto.getLimit();
        int page = offset / limit;
        return grupoService.filteredList(specs, PageRequest.of(page, limit));
    }

    @GetMapping(path="/count")
    public ResponseEntity<Long> count() {
        return ResponseEntity.ok(grupoService.count());
    }

    @PostMapping(path="/countFilteredList")
    public ResponseEntity<Long> countFilteredList(@RequestBody GrupoDto grupoDto) {
        Specification<Grupo> specs = new GrupoSpecifications(grupoDto);
        return ResponseEntity.ok(grupoService.countFilteredList(specs));
    }
}
