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

import com.artplusplus.contpp.model.PagoBono;
import com.artplusplus.contpp.service.PagoBonoService;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController // This means that this class is a Controller
@RequestMapping(path="/api/pago_bono") // This means URL's start with / (after Application path)
public class PagoBonoController {
    @Autowired
    private PagoBonoService pagoBonoService;

    @PostMapping(path="/add") // Map ONLY POST Requests
    public ResponseEntity<PagoBono> add(@RequestBody PagoBono pagoBono) {
        // @ResponseBody means the returned Entity is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request
        PagoBono obj = pagoBonoService.save(pagoBono);
        return ResponseEntity.ok(obj);
    }

    @PutMapping(path="/{id}")
    public ResponseEntity<PagoBono> update(@RequestBody PagoBono pagoBono,
                     @PathVariable Long id){
        PagoBono obj = pagoBonoService.save(pagoBono);
        return ResponseEntity.ok(obj);
    }

    @GetMapping(path="/")
    public @ResponseBody List<PagoBono> all() {
        // This returns a JSON or XML
        return pagoBonoService.list();
    }

    @DeleteMapping(path="/{id}")
    public ResponseEntity<String> deleteById(@PathVariable String id) {
        Long pagoBonoId = Long.parseLong(id);
        if(pagoBonoService.existsById(pagoBonoId)){
            pagoBonoService.deleteById(pagoBonoId);
            return ResponseEntity.ok("Deleted");
        }
        return ResponseEntity.ok("ID not found");
    }
}
