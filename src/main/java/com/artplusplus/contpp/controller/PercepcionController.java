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

import com.artplusplus.contpp.model.Percepcion;
import com.artplusplus.contpp.service.PercepcionService;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController // This means that this class is a Controller
@RequestMapping(path="/api/percepcion") // This means URL's start with / (after Application path)
public class PercepcionController {
    @Autowired
    private PercepcionService percepcionService;

    @PostMapping(path="/add") // Map ONLY POST Requests
    public ResponseEntity<Percepcion> add(@RequestBody Percepcion percepcion) {
        // @ResponseBody means the returned Entity is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request
        Percepcion obj = percepcionService.save(percepcion);
        return ResponseEntity.ok(obj);
    }

    @PutMapping(path="/{id}")
    public ResponseEntity<Percepcion> update(@RequestBody Percepcion percepcion,
                     @PathVariable Long id){
        Percepcion obj = percepcionService.save(percepcion);
        return ResponseEntity.ok(obj);
    }

    @GetMapping(path="/")
    public @ResponseBody List<Percepcion> all() {
        // This returns a JSON or XML
        return percepcionService.list();
    }

    @DeleteMapping(path="/{id}")
    public ResponseEntity<String> deleteById(@PathVariable String id) {
        Long percepcionId = Long.parseLong(id);
        if(percepcionService.existsById(percepcionId)){
            percepcionService.deleteById(percepcionId);
            return ResponseEntity.ok("Deleted");
        }
        return ResponseEntity.ok("ID not found");
    }
}
