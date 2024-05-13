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

import com.artplusplus.contpp.model.EmpleadoCuentaBancaria;
import com.artplusplus.contpp.service.EmpleadoCuentaBancariaService;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController // This means that this class is a Controller
@RequestMapping(path="/api/empleado_cuenta_bancaria") // This means URL's start with / (after Application path)
public class EmpleadoCuentaBancariaController {
    @Autowired
    private EmpleadoCuentaBancariaService empleadoCuentaBancariaService;

    @PostMapping(path="/add") // Map ONLY POST Requests
    public ResponseEntity<EmpleadoCuentaBancaria> add(@RequestBody EmpleadoCuentaBancaria empleadoCuentaBancaria) {
        // @ResponseBody means the returned Entity is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request
        EmpleadoCuentaBancaria obj = empleadoCuentaBancariaService.save(empleadoCuentaBancaria);
        return ResponseEntity.ok(obj);
    }

    @PutMapping(path="/{id}")
    public ResponseEntity<EmpleadoCuentaBancaria> update(@RequestBody EmpleadoCuentaBancaria empleadoCuentaBancaria,
                     @PathVariable Long id){
        EmpleadoCuentaBancaria obj = empleadoCuentaBancariaService.save(empleadoCuentaBancaria);
        return ResponseEntity.ok(obj);
    }

    @GetMapping(path="/")
    public @ResponseBody List<EmpleadoCuentaBancaria> all() {
        // This returns a JSON or XML
        return empleadoCuentaBancariaService.list();
    }

    @DeleteMapping(path="/{id}")
    public ResponseEntity<String> deleteById(@PathVariable String id) {
        Long empleadoCuentaBancariaId = Long.parseLong(id);
        if(empleadoCuentaBancariaService.existsById(empleadoCuentaBancariaId)){
            empleadoCuentaBancariaService.deleteById(empleadoCuentaBancariaId);
            return ResponseEntity.ok("Deleted");
        }
        return ResponseEntity.ok("ID not found");
    }
}
