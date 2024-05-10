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

import com.artplusplus.contpp.model.Sucursal;
import com.artplusplus.contpp.service.SucursalService;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController // This means that this class is a Controller
@RequestMapping(path="/api/sucursal") // This means URL's start with /sucursal (after Application path)
public class SucursalController {
    @Autowired 
    private SucursalService sucursalService;

    @PostMapping(path="/add") // Map ONLY POST Requests
    public ResponseEntity<Sucursal> add(@RequestBody Sucursal sucursal) {
        // @ResponseBody means the returned Entity is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request
        Sucursal obj = sucursalService.save(sucursal);
        return ResponseEntity.ok(obj);
    }

    @PutMapping(path="/{id}")
    public ResponseEntity<Sucursal> update(@RequestBody Sucursal sucursal,
                     @PathVariable Long id){
        Sucursal obj = sucursalService.save(sucursal);
        return ResponseEntity.ok(obj);
    }

    @GetMapping(path="/")
    public @ResponseBody List<Sucursal> all() {
        // This returns a JSON or XML with the users
        return sucursalService.list();
    }

    @DeleteMapping(path="/{id}")
    public ResponseEntity<String> deleteById(@PathVariable String id) {
        Long sucursalId = Long.parseLong(id);
        if(sucursalService.existsById(sucursalId)){
            sucursalService.deleteById(sucursalId);
            return ResponseEntity.ok("Deleted");
        }
        return ResponseEntity.ok("ID not found");
    }
}
