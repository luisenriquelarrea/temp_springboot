package com.artplusplus.contpp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.artplusplus.contpp.model.Plaza;
import com.artplusplus.contpp.service.PlazaService;

import java.util.List;

@Controller // This means that this class is a Controller
@RequestMapping(path="/api/plaza") // This means URL's start with /plaza (after Application path)
public class PlazaController {
    @Autowired private PlazaService plazaService;

    @PostMapping(path="/add") // Map ONLY POST Requests
    public ResponseEntity<Plaza> add(@RequestBody Plaza plaza) {
        // @ResponseBody means the returned Entity is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request
        Plaza newPlaza = plazaService.savePlaza(plaza);
        return ResponseEntity.ok(newPlaza);
    }

    @GetMapping(path="/")
    public @ResponseBody List<Plaza> all() {
        // This returns a JSON or XML with the users
        return plazaService.listPlaza();
    }

    @PutMapping(path="/{id}")
    public ResponseEntity<Plaza> update(@RequestBody Plaza plaza,
                     @PathVariable Long id){
        Plaza updPlaza = plazaService.savePlaza(plaza);
        return ResponseEntity.ok(updPlaza);
    }

    @DeleteMapping(path="/{id}")
    public ResponseEntity<String> delete(@PathVariable String id) {
        Long plazaId = Long.parseLong(id);
        if(plazaService.getById(plazaId)){
            plazaService.deletePlaza(plazaId);
            return ResponseEntity.ok("Deleted");
        }
        return ResponseEntity.ok("ID not found");
    }

    @GetMapping(path="/{id}")
    public ResponseEntity<Plaza> getById(@PathVariable Long id){
        if(plazaService.getById(id)){
            Plaza plaza = plazaService.plazaById(id);
            return ResponseEntity.ok(plaza);
        }
        return ResponseEntity.notFound().build();
    }
}
