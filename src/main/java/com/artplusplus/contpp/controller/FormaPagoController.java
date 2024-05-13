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

import com.artplusplus.contpp.model.FormaPago;
import com.artplusplus.contpp.service.FormaPagoService;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController // This means that this class is a Controller
@RequestMapping(path="/api/forma_pago") // This means URL's start with / (after Application path)
public class FormaPagoController {
    @Autowired
    private FormaPagoService formaPagoService;

    @PostMapping(path="/add") // Map ONLY POST Requests
    public ResponseEntity<FormaPago> add(@RequestBody FormaPago formaPago) {
        // @ResponseBody means the returned Entity is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request
        FormaPago obj = formaPagoService.save(formaPago);
        return ResponseEntity.ok(obj);
    }

    @PutMapping(path="/{id}")
    public ResponseEntity<FormaPago> update(@RequestBody FormaPago formaPago,
                     @PathVariable Long id){
        FormaPago obj = formaPagoService.save(formaPago);
        return ResponseEntity.ok(obj);
    }

    @GetMapping(path="/")
    public @ResponseBody List<FormaPago> all() {
        // This returns a JSON or XML
        return formaPagoService.list();
    }

    @DeleteMapping(path="/{id}")
    public ResponseEntity<String> deleteById(@PathVariable String id) {
        Long formaPagoId = Long.parseLong(id);
        if(formaPagoService.existsById(formaPagoId)){
            formaPagoService.deleteById(formaPagoId);
            return ResponseEntity.ok("Deleted");
        }
        return ResponseEntity.ok("ID not found");
    }
}
