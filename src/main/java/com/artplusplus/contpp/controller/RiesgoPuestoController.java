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

import com.artplusplus.contpp.model.RiesgoPuesto;
import com.artplusplus.contpp.service.RiesgoPuestoService;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController // This means that this class is a Controller
@RequestMapping(path="/api/riesgo_puesto") // This means URL's start with / (after Application path)
public class RiesgoPuestoController {
    @Autowired
    private RiesgoPuestoService riesgoPuestoService;

    @PostMapping(path="/add") // Map ONLY POST Requests
    public ResponseEntity<RiesgoPuesto> add(@RequestBody RiesgoPuesto riesgoPuesto) {
        // @ResponseBody means the returned Entity is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request
        RiesgoPuesto obj = riesgoPuestoService.save(riesgoPuesto);
        return ResponseEntity.ok(obj);
    }

    @PutMapping(path="/{id}")
    public ResponseEntity<RiesgoPuesto> update(@RequestBody RiesgoPuesto riesgoPuesto,
                     @PathVariable Long id){
        RiesgoPuesto obj = riesgoPuestoService.save(riesgoPuesto);
        return ResponseEntity.ok(obj);
    }

    @GetMapping(path="/")
    public @ResponseBody List<RiesgoPuesto> all() {
        // This returns a JSON or XML
        return riesgoPuestoService.list();
    }

    @DeleteMapping(path="/{id}")
    public ResponseEntity<String> deleteById(@PathVariable String id) {
        Long riesgoPuestoId = Long.parseLong(id);
        if(riesgoPuestoService.existsById(riesgoPuestoId)){
            riesgoPuestoService.deleteById(riesgoPuestoId);
            return ResponseEntity.ok("Deleted");
        }
        return ResponseEntity.ok("ID not found");
    }
}
