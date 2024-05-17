package com.artplusplus.contpp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

import com.artplusplus.contpp.model.Concepto;
import com.artplusplus.contpp.service.ConceptoService;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController // This means that this class is a Controller
@RequestMapping(path="/api/concepto") // This means URL's start with / (after Application path)
public class ConceptoController {
    @Autowired
    private ConceptoService conceptoService;

    @PostMapping(path="/add") // Map ONLY POST Requests
    public ResponseEntity<Concepto> add(@RequestBody Concepto concepto) {
        // @ResponseBody means the returned Entity is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request
        Concepto obj = conceptoService.save(concepto);
        return ResponseEntity.ok(obj);
    }

    @PutMapping(path="/{id}")
    public ResponseEntity<Concepto> update(@RequestBody Concepto concepto,
                     @PathVariable Long id){
        Concepto obj = conceptoService.save(concepto);
        return ResponseEntity.ok(obj);
    }

    @GetMapping(path="/")
    public @ResponseBody List<Concepto> all() {
        // This returns a JSON or XML
        return conceptoService.list();
    }

    @DeleteMapping(path="/{id}")
    public ResponseEntity<String> deleteById(@PathVariable String id) {
        Long conceptoId = Long.parseLong(id);
        if(conceptoService.existsById(conceptoId)){
            conceptoService.deleteById(conceptoId);
            return ResponseEntity.ok("Deleted");
        }
        return ResponseEntity.ok("ID not found");
    }
}
