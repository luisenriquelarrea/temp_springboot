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

import com.artplusplus.contpp.model.SalarioMinimo;
import com.artplusplus.contpp.service.SalarioMinimoService;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController // This means that this class is a Controller
@RequestMapping(path="/api/salario_minimo") // This means URL's start with / (after Application path)
public class SalarioMinimoController {
    @Autowired
    private SalarioMinimoService salarioMinimoService;

    @PostMapping(path="/add") // Map ONLY POST Requests
    public ResponseEntity<SalarioMinimo> add(@RequestBody SalarioMinimo salarioMinimo) {
        // @ResponseBody means the returned Entity is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request
        SalarioMinimo obj = salarioMinimoService.save(salarioMinimo);
        return ResponseEntity.ok(obj);
    }

    @PutMapping(path="/{id}")
    public ResponseEntity<SalarioMinimo> update(@RequestBody SalarioMinimo salarioMinimo,
                     @PathVariable Long id){
        SalarioMinimo obj = salarioMinimoService.save(salarioMinimo);
        return ResponseEntity.ok(obj);
    }

    @GetMapping(path="/")
    public @ResponseBody List<SalarioMinimo> all() {
        // This returns a JSON or XML
        return salarioMinimoService.list();
    }

    @DeleteMapping(path="/{id}")
    public ResponseEntity<String> deleteById(@PathVariable String id) {
        Long salarioMinimoId = Long.parseLong(id);
        if(salarioMinimoService.existsById(salarioMinimoId)){
            salarioMinimoService.deleteById(salarioMinimoId);
            return ResponseEntity.ok("Deleted");
        }
        return ResponseEntity.ok("ID not found");
    }
}
