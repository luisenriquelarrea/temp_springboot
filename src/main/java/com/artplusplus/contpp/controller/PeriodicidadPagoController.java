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

import com.artplusplus.contpp.model.PeriodicidadPago;
import com.artplusplus.contpp.service.PeriodicidadPagoService;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController // This means that this class is a Controller
@RequestMapping(path="/api/periodicidad_pago") // This means URL's start with /periodicidad_pago (after Application path)
public class PeriodicidadPagoController {
    @Autowired 
    private PeriodicidadPagoService periodicidadPagoService;

    @PostMapping(path="/add") // Map ONLY POST Requests
    public ResponseEntity<PeriodicidadPago> add(@RequestBody PeriodicidadPago periodicidadPago) {
        // @ResponseBody means the returned Entity is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request
        PeriodicidadPago obj = periodicidadPagoService.save(periodicidadPago);
        return ResponseEntity.ok(obj);
    }

    @PutMapping(path="/{id}")
    public ResponseEntity<PeriodicidadPago> update(@RequestBody PeriodicidadPago periodicidadPago,
                     @PathVariable Long id){
        PeriodicidadPago obj = periodicidadPagoService.save(periodicidadPago);
        return ResponseEntity.ok(obj);
    }

    @GetMapping(path="/")
    public @ResponseBody List<PeriodicidadPago> all() {
        // This returns a JSON or XML with the users
        return periodicidadPagoService.list();
    }

    @DeleteMapping(path="/{id}")
    public ResponseEntity<String> deleteById(@PathVariable String id) {
        Long periodicidadPagoId = Long.parseLong(id);
        if(periodicidadPagoService.existsById(periodicidadPagoId)){
            periodicidadPagoService.deleteById(periodicidadPagoId);
            return ResponseEntity.ok("Deleted");
        }
        return ResponseEntity.ok("ID not found");
    }
}
