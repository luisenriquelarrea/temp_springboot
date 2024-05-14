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

import com.artplusplus.contpp.model.PagoDescuento;
import com.artplusplus.contpp.service.PagoDescuentoService;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController // This means that this class is a Controller
@RequestMapping(path="/api/pago_descuento") // This means URL's start with / (after Application path)
public class PagoDescuentoController {
    @Autowired
    private PagoDescuentoService pagoDescuentoService;

    @PostMapping(path="/add") // Map ONLY POST Requests
    public ResponseEntity<PagoDescuento> add(@RequestBody PagoDescuento pagoDescuento) {
        // @ResponseBody means the returned Entity is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request
        PagoDescuento obj = pagoDescuentoService.save(pagoDescuento);
        return ResponseEntity.ok(obj);
    }

    @PutMapping(path="/{id}")
    public ResponseEntity<PagoDescuento> update(@RequestBody PagoDescuento pagoDescuento,
                     @PathVariable Long id){
        PagoDescuento obj = pagoDescuentoService.save(pagoDescuento);
        return ResponseEntity.ok(obj);
    }

    @GetMapping(path="/")
    public @ResponseBody List<PagoDescuento> all() {
        // This returns a JSON or XML
        return pagoDescuentoService.list();
    }

    @DeleteMapping(path="/{id}")
    public ResponseEntity<String> deleteById(@PathVariable String id) {
        Long pagoDescuentoId = Long.parseLong(id);
        if(pagoDescuentoService.existsById(pagoDescuentoId)){
            pagoDescuentoService.deleteById(pagoDescuentoId);
            return ResponseEntity.ok("Deleted");
        }
        return ResponseEntity.ok("ID not found");
    }
}
