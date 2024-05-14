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

import com.artplusplus.contpp.model.IsrMensual;
import com.artplusplus.contpp.service.IsrMensualService;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController // This means that this class is a Controller
@RequestMapping(path="/api/isr_mensual") // This means URL's start with / (after Application path)
public class IsrMensualController {
    @Autowired
    private IsrMensualService isrMensualService;

    @PostMapping(path="/add") // Map ONLY POST Requests
    public ResponseEntity<IsrMensual> add(@RequestBody IsrMensual isrMensual) {
        // @ResponseBody means the returned Entity is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request
        IsrMensual obj = isrMensualService.save(isrMensual);
        return ResponseEntity.ok(obj);
    }

    @PutMapping(path="/{id}")
    public ResponseEntity<IsrMensual> update(@RequestBody IsrMensual isrMensual,
                     @PathVariable Long id){
        IsrMensual obj = isrMensualService.save(isrMensual);
        return ResponseEntity.ok(obj);
    }

    @GetMapping(path="/")
    public @ResponseBody List<IsrMensual> all() {
        // This returns a JSON or XML
        return isrMensualService.list();
    }

    @DeleteMapping(path="/{id}")
    public ResponseEntity<String> deleteById(@PathVariable String id) {
        Long isrMensualId = Long.parseLong(id);
        if(isrMensualService.existsById(isrMensualId)){
            isrMensualService.deleteById(isrMensualId);
            return ResponseEntity.ok("Deleted");
        }
        return ResponseEntity.ok("ID not found");
    }
}
