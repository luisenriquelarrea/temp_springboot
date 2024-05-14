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

import com.artplusplus.contpp.model.Incidencia;
import com.artplusplus.contpp.service.IncidenciaService;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController // This means that this class is a Controller
@RequestMapping(path="/api/incidencia") // This means URL's start with / (after Application path)
public class IncidenciaController {
    @Autowired
    private IncidenciaService incidenciaService;

    @PostMapping(path="/add") // Map ONLY POST Requests
    public ResponseEntity<Incidencia> add(@RequestBody Incidencia incidencia) {
        // @ResponseBody means the returned Entity is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request
        Incidencia obj = incidenciaService.save(incidencia);
        return ResponseEntity.ok(obj);
    }

    @PutMapping(path="/{id}")
    public ResponseEntity<Incidencia> update(@RequestBody Incidencia incidencia,
                     @PathVariable Long id){
        Incidencia obj = incidenciaService.save(incidencia);
        return ResponseEntity.ok(obj);
    }

    @GetMapping(path="/")
    public @ResponseBody List<Incidencia> all() {
        // This returns a JSON or XML
        return incidenciaService.list();
    }

    @DeleteMapping(path="/{id}")
    public ResponseEntity<String> deleteById(@PathVariable String id) {
        Long incidenciaId = Long.parseLong(id);
        if(incidenciaService.existsById(incidenciaId)){
            incidenciaService.deleteById(incidenciaId);
            return ResponseEntity.ok("Deleted");
        }
        return ResponseEntity.ok("ID not found");
    }
}
