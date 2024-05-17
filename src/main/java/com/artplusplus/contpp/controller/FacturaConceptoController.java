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

import com.artplusplus.contpp.model.FacturaConcepto;
import com.artplusplus.contpp.service.FacturaConceptoService;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController // This means that this class is a Controller
@RequestMapping(path="/api/factura_concepto") // This means URL's start with / (after Application path)
public class FacturaConceptoController {
    @Autowired
    private FacturaConceptoService facturaConceptoService;

    @PostMapping(path="/add") // Map ONLY POST Requests
    public ResponseEntity<FacturaConcepto> add(@RequestBody FacturaConcepto facturaConcepto) {
        // @ResponseBody means the returned Entity is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request
        FacturaConcepto obj = facturaConceptoService.save(facturaConcepto);
        return ResponseEntity.ok(obj);
    }

    @PutMapping(path="/{id}")
    public ResponseEntity<FacturaConcepto> update(@RequestBody FacturaConcepto facturaConcepto,
                     @PathVariable Long id){
        FacturaConcepto obj = facturaConceptoService.save(facturaConcepto);
        return ResponseEntity.ok(obj);
    }

    @GetMapping(path="/")
    public @ResponseBody List<FacturaConcepto> all() {
        // This returns a JSON or XML
        return facturaConceptoService.list();
    }

    @DeleteMapping(path="/{id}")
    public ResponseEntity<String> deleteById(@PathVariable String id) {
        Long facturaConceptoId = Long.parseLong(id);
        if(facturaConceptoService.existsById(facturaConceptoId)){
            facturaConceptoService.deleteById(facturaConceptoId);
            return ResponseEntity.ok("Deleted");
        }
        return ResponseEntity.ok("ID not found");
    }
}
