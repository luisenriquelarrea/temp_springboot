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

import com.artplusplus.contpp.model.Ejercicio;
import com.artplusplus.contpp.service.EjercicioService;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController // This means that this class is a Controller
@RequestMapping(path="/api/ejercicio") // This means URL's start with / (after Application path)
public class EjercicioController {
    @Autowired
    private EjercicioService ejercicioService;

    @PostMapping(path="/add") // Map ONLY POST Requests
    public ResponseEntity<Ejercicio> add(@RequestBody Ejercicio ejercicio) {
        // @ResponseBody means the returned Entity is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request
        Ejercicio obj = ejercicioService.save(ejercicio);
        return ResponseEntity.ok(obj);
    }

    @PutMapping(path="/{id}")
    public ResponseEntity<Ejercicio> update(@RequestBody Ejercicio ejercicio,
                     @PathVariable Long id){
        Ejercicio obj = ejercicioService.save(ejercicio);
        return ResponseEntity.ok(obj);
    }

    @GetMapping(path="/")
    public @ResponseBody List<Ejercicio> all() {
        // This returns a JSON or XML
        return ejercicioService.list();
    }

    @DeleteMapping(path="/{id}")
    public ResponseEntity<String> deleteById(@PathVariable String id) {
        Long ejercicioId = Long.parseLong(id);
        if(ejercicioService.existsById(ejercicioId)){
            ejercicioService.deleteById(ejercicioId);
            return ResponseEntity.ok("Deleted");
        }
        return ResponseEntity.ok("ID not found");
    }
}
