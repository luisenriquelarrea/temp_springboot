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

import com.artplusplus.contpp.model.Prenomina;
import com.artplusplus.contpp.service.PrenominaService;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController // This means that this class is a Controller
@RequestMapping(path="/api/prenomina") // This means URL's start with / (after Application path)
public class PrenominaController {
    @Autowired
    private PrenominaService prenominaService;

    @PostMapping(path="/add") // Map ONLY POST Requests
    public ResponseEntity<Prenomina> add(@RequestBody Prenomina prenomina) {
        // @ResponseBody means the returned Entity is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request
        Prenomina obj = prenominaService.save(prenomina);
        return ResponseEntity.ok(obj);
    }

    @PutMapping(path="/{id}")
    public ResponseEntity<Prenomina> update(@RequestBody Prenomina prenomina,
                     @PathVariable Long id){
        Prenomina obj = prenominaService.save(prenomina);
        return ResponseEntity.ok(obj);
    }

    @GetMapping(path="/")
    public @ResponseBody List<Prenomina> all() {
        // This returns a JSON or XML
        return prenominaService.list();
    }

    @DeleteMapping(path="/{id}")
    public ResponseEntity<String> deleteById(@PathVariable String id) {
        Long prenominaId = Long.parseLong(id);
        if(prenominaService.existsById(prenominaId)){
            prenominaService.deleteById(prenominaId);
            return ResponseEntity.ok("Deleted");
        }
        return ResponseEntity.ok("ID not found");
    }
}
