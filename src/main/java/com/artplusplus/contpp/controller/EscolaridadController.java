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

import com.artplusplus.contpp.model.Escolaridad;
import com.artplusplus.contpp.service.EscolaridadService;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController // This means that this class is a Controller
@RequestMapping(path="/api/escolaridad") // This means URL's start with / (after Application path)
public class EscolaridadController {
    @Autowired
    private EscolaridadService escolaridadService;

    @PostMapping(path="/add") // Map ONLY POST Requests
    public ResponseEntity<Escolaridad> add(@RequestBody Escolaridad escolaridad) {
        // @ResponseBody means the returned Entity is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request
        Escolaridad obj = escolaridadService.save(escolaridad);
        return ResponseEntity.ok(obj);
    }

    @PutMapping(path="/{id}")
    public ResponseEntity<Escolaridad> update(@RequestBody Escolaridad escolaridad,
                     @PathVariable Long id){
        Escolaridad obj = escolaridadService.save(escolaridad);
        return ResponseEntity.ok(obj);
    }

    @GetMapping(path="/")
    public @ResponseBody List<Escolaridad> all() {
        // This returns a JSON or XML
        return escolaridadService.list();
    }

    @DeleteMapping(path="/{id}")
    public ResponseEntity<String> deleteById(@PathVariable String id) {
        Long escolaridadId = Long.parseLong(id);
        if(escolaridadService.existsById(escolaridadId)){
            escolaridadService.deleteById(escolaridadId);
            return ResponseEntity.ok("Deleted");
        }
        return ResponseEntity.ok("ID not found");
    }
}
