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

import com.artplusplus.contpp.model.NotaCredito;
import com.artplusplus.contpp.service.NotaCreditoService;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController // This means that this class is a Controller
@RequestMapping(path="/api/nota_credito") // This means URL's start with / (after Application path)
public class NotaCreditoController {
    @Autowired
    private NotaCreditoService notaCreditoService;

    @PostMapping(path="/add") // Map ONLY POST Requests
    public ResponseEntity<NotaCredito> add(@RequestBody NotaCredito notaCredito) {
        // @ResponseBody means the returned Entity is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request
        NotaCredito obj = notaCreditoService.save(notaCredito);
        return ResponseEntity.ok(obj);
    }

    @PutMapping(path="/{id}")
    public ResponseEntity<NotaCredito> update(@RequestBody NotaCredito notaCredito,
                     @PathVariable Long id){
        NotaCredito obj = notaCreditoService.save(notaCredito);
        return ResponseEntity.ok(obj);
    }

    @GetMapping(path="/")
    public @ResponseBody List<NotaCredito> all() {
        // This returns a JSON or XML
        return notaCreditoService.list();
    }

    @DeleteMapping(path="/{id}")
    public ResponseEntity<String> deleteById(@PathVariable String id) {
        Long notaCreditoId = Long.parseLong(id);
        if(notaCreditoService.existsById(notaCreditoId)){
            notaCreditoService.deleteById(notaCreditoId);
            return ResponseEntity.ok("Deleted");
        }
        return ResponseEntity.ok("ID not found");
    }
}
