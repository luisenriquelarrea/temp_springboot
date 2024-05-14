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

import com.artplusplus.contpp.model.PrenominaDetalle;
import com.artplusplus.contpp.service.PrenominaDetalleService;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController // This means that this class is a Controller
@RequestMapping(path="/api/prenomina_detalle") // This means URL's start with / (after Application path)
public class PrenominaDetalleController {
    @Autowired
    private PrenominaDetalleService prenominaDetalleService;

    @PostMapping(path="/add") // Map ONLY POST Requests
    public ResponseEntity<PrenominaDetalle> add(@RequestBody PrenominaDetalle prenominaDetalle) {
        // @ResponseBody means the returned Entity is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request
        PrenominaDetalle obj = prenominaDetalleService.save(prenominaDetalle);
        return ResponseEntity.ok(obj);
    }

    @PutMapping(path="/{id}")
    public ResponseEntity<PrenominaDetalle> update(@RequestBody PrenominaDetalle prenominaDetalle,
                     @PathVariable Long id){
        PrenominaDetalle obj = prenominaDetalleService.save(prenominaDetalle);
        return ResponseEntity.ok(obj);
    }

    @GetMapping(path="/")
    public @ResponseBody List<PrenominaDetalle> all() {
        // This returns a JSON or XML
        return prenominaDetalleService.list();
    }

    @DeleteMapping(path="/{id}")
    public ResponseEntity<String> deleteById(@PathVariable String id) {
        Long prenominaDetalleId = Long.parseLong(id);
        if(prenominaDetalleService.existsById(prenominaDetalleId)){
            prenominaDetalleService.deleteById(prenominaDetalleId);
            return ResponseEntity.ok("Deleted");
        }
        return ResponseEntity.ok("ID not found");
    }
}
