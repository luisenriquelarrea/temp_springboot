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

import com.artplusplus.contpp.model.ComplementoPago;
import com.artplusplus.contpp.service.ComplementoPagoService;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController // This means that this class is a Controller
@RequestMapping(path="/api/complemento_pago") // This means URL's start with / (after Application path)
public class ComplementoPagoController {
    @Autowired
    private ComplementoPagoService complementoPagoService;

    @PostMapping(path="/add") // Map ONLY POST Requests
    public ResponseEntity<ComplementoPago> add(@RequestBody ComplementoPago complementoPago) {
        // @ResponseBody means the returned Entity is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request
        ComplementoPago obj = complementoPagoService.save(complementoPago);
        return ResponseEntity.ok(obj);
    }

    @PutMapping(path="/{id}")
    public ResponseEntity<ComplementoPago> update(@RequestBody ComplementoPago complementoPago,
                     @PathVariable Long id){
        ComplementoPago obj = complementoPagoService.save(complementoPago);
        return ResponseEntity.ok(obj);
    }

    @GetMapping(path="/")
    public @ResponseBody List<ComplementoPago> all() {
        // This returns a JSON or XML
        return complementoPagoService.list();
    }

    @DeleteMapping(path="/{id}")
    public ResponseEntity<String> deleteById(@PathVariable String id) {
        Long complementoPagoId = Long.parseLong(id);
        if(complementoPagoService.existsById(complementoPagoId)){
            complementoPagoService.deleteById(complementoPagoId);
            return ResponseEntity.ok("Deleted");
        }
        return ResponseEntity.ok("ID not found");
    }
}
