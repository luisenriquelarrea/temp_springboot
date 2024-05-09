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

import com.artplusplus.contpp.model.Puesto;
import com.artplusplus.contpp.service.PuestoService;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController // This means that this class is a Controller
@RequestMapping(path="/api/puesto") // This means URL's start with /puesto (after Application path)
public class PuestoController {
    @Autowired 
    private PuestoService puestoService;

    @PostMapping(path="/add") // Map ONLY POST Requests
    public ResponseEntity<Puesto> add(@RequestBody Puesto puesto) {
        // @ResponseBody means the returned Entity is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request
        Puesto obj = puestoService.save(puesto);
        return ResponseEntity.ok(obj);
    }

    @PutMapping(path="/{id}")
    public ResponseEntity<Puesto> update(@RequestBody Puesto puesto,
                     @PathVariable Long id){
        Puesto obj = puestoService.save(puesto);
        return ResponseEntity.ok(obj);
    }

    @GetMapping(path="/")
    public @ResponseBody List<Puesto> all() {
        // This returns a JSON or XML with the users
        return puestoService.list();
    }

    @DeleteMapping(path="/{id}")
    public ResponseEntity<String> deleteById(@PathVariable String id) {
        Long puestoId = Long.parseLong(id);
        if(puestoService.existsById(puestoId)){
            puestoService.deleteById(puestoId);
            return ResponseEntity.ok("Deleted");
        }
        return ResponseEntity.ok("ID not found");
    }
}
