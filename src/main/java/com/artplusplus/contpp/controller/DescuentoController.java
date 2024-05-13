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

import com.artplusplus.contpp.model.Descuento;
import com.artplusplus.contpp.service.DescuentoService;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController // This means that this class is a Controller
@RequestMapping(path="/api/descuento") // This means URL's start with / (after Application path)
public class DescuentoController {
    @Autowired
    private DescuentoService descuentoService;

    @PostMapping(path="/add") // Map ONLY POST Requests
    public ResponseEntity<Descuento> add(@RequestBody Descuento descuento) {
        // @ResponseBody means the returned Entity is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request
        Descuento obj = descuentoService.save(descuento);
        return ResponseEntity.ok(obj);
    }

    @PutMapping(path="/{id}")
    public ResponseEntity<Descuento> update(@RequestBody Descuento descuento,
                     @PathVariable Long id){
        Descuento obj = descuentoService.save(descuento);
        return ResponseEntity.ok(obj);
    }

    @GetMapping(path="/")
    public @ResponseBody List<Descuento> all() {
        // This returns a JSON or XML
        return descuentoService.list();
    }

    @DeleteMapping(path="/{id}")
    public ResponseEntity<String> deleteById(@PathVariable String id) {
        Long descuentoId = Long.parseLong(id);
        if(descuentoService.existsById(descuentoId)){
            descuentoService.deleteById(descuentoId);
            return ResponseEntity.ok("Deleted");
        }
        return ResponseEntity.ok("ID not found");
    }
}
