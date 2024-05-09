package com.artplusplus.contpp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.artplusplus.contpp.model.Departamento;
import com.artplusplus.contpp.service.DepartamentoService;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController // This means that this class is a Controller
@RequestMapping(path="/api/departamento") // This means URL's start with /departamento (after Application path)
public class DepartamentoController {
    @Autowired 
    private DepartamentoService departamentoService;

    @PostMapping(path="/add") // Map ONLY POST Requests
    public ResponseEntity<Departamento> add(@RequestBody Departamento departamento) {
        // @ResponseBody means the returned Entity is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request
        Departamento obj = departamentoService.save(departamento);
        return ResponseEntity.ok(obj);
    }

    @PutMapping(path="/{id}")
    public ResponseEntity<Departamento> update(@RequestBody Departamento departamento,
                     @PathVariable Long id){
        Departamento obj = departamentoService.save(departamento);
        return ResponseEntity.ok(obj);
    }

    @GetMapping(path="/")
    public @ResponseBody List<Departamento> all() {
        // This returns a JSON or XML with the users
        return departamentoService.list();
    }

    @DeleteMapping(path="/{id}")
    public ResponseEntity<String> deleteById(@PathVariable String id) {
        Long departamentoId = Long.parseLong(id);
        if(departamentoService.existsById(departamentoId)){
            departamentoService.deleteById(departamentoId);
            return ResponseEntity.ok("Deleted");
        }
        return ResponseEntity.ok("ID not found");
    }
}
