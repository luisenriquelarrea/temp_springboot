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

import com.artplusplus.contpp.model.ReciboDeduccion;
import com.artplusplus.contpp.service.ReciboDeduccionService;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController // This means that this class is a Controller
@RequestMapping(path="/api/recibo_deduccion") // This means URL's start with / (after Application path)
public class ReciboDeduccionController {
    @Autowired
    private ReciboDeduccionService reciboDeduccionService;

    @PostMapping(path="/add") // Map ONLY POST Requests
    public ResponseEntity<ReciboDeduccion> add(@RequestBody ReciboDeduccion reciboDeduccion) {
        // @ResponseBody means the returned Entity is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request
        ReciboDeduccion obj = reciboDeduccionService.save(reciboDeduccion);
        return ResponseEntity.ok(obj);
    }

    @PutMapping(path="/{id}")
    public ResponseEntity<ReciboDeduccion> update(@RequestBody ReciboDeduccion reciboDeduccion,
                     @PathVariable Long id){
        ReciboDeduccion obj = reciboDeduccionService.save(reciboDeduccion);
        return ResponseEntity.ok(obj);
    }

    @GetMapping(path="/")
    public @ResponseBody List<ReciboDeduccion> all() {
        // This returns a JSON or XML
        return reciboDeduccionService.list();
    }

    @DeleteMapping(path="/{id}")
    public ResponseEntity<String> deleteById(@PathVariable String id) {
        Long reciboDeduccionId = Long.parseLong(id);
        if(reciboDeduccionService.existsById(reciboDeduccionId)){
            reciboDeduccionService.deleteById(reciboDeduccionId);
            return ResponseEntity.ok("Deleted");
        }
        return ResponseEntity.ok("ID not found");
    }
}
