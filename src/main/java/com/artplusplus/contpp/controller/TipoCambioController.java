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

import com.artplusplus.contpp.model.TipoCambio;
import com.artplusplus.contpp.service.TipoCambioService;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController // This means that this class is a Controller
@RequestMapping(path="/api/tipo_cambio") // This means URL's start with / (after Application path)
public class TipoCambioController {
    @Autowired
    private TipoCambioService tipoCambioService;

    @PostMapping(path="/add") // Map ONLY POST Requests
    public ResponseEntity<TipoCambio> add(@RequestBody TipoCambio tipoCambio) {
        // @ResponseBody means the returned Entity is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request
        TipoCambio obj = tipoCambioService.save(tipoCambio);
        return ResponseEntity.ok(obj);
    }

    @PutMapping(path="/{id}")
    public ResponseEntity<TipoCambio> update(@RequestBody TipoCambio tipoCambio,
                     @PathVariable Long id){
        TipoCambio obj = tipoCambioService.save(tipoCambio);
        return ResponseEntity.ok(obj);
    }

    @GetMapping(path="/")
    public @ResponseBody List<TipoCambio> all() {
        // This returns a JSON or XML
        return tipoCambioService.list();
    }

    @DeleteMapping(path="/{id}")
    public ResponseEntity<String> deleteById(@PathVariable String id) {
        Long tipoCambioId = Long.parseLong(id);
        if(tipoCambioService.existsById(tipoCambioId)){
            tipoCambioService.deleteById(tipoCambioId);
            return ResponseEntity.ok("Deleted");
        }
        return ResponseEntity.ok("ID not found");
    }
}
