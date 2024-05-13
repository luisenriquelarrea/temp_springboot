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

import com.artplusplus.contpp.model.EmpleadoEmpresa;
import com.artplusplus.contpp.service.EmpleadoEmpresaService;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController // This means that this class is a Controller
@RequestMapping(path="/api/empleado_empresa") // This means URL's start with / (after Application path)
public class EmpleadoEmpresaController {
    @Autowired
    private EmpleadoEmpresaService empleadoEmpresaService;

    @PostMapping(path="/add") // Map ONLY POST Requests
    public ResponseEntity<EmpleadoEmpresa> add(@RequestBody EmpleadoEmpresa empleadoEmpresa) {
        // @ResponseBody means the returned Entity is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request
        EmpleadoEmpresa obj = empleadoEmpresaService.save(empleadoEmpresa);
        return ResponseEntity.ok(obj);
    }

    @PutMapping(path="/{id}")
    public ResponseEntity<EmpleadoEmpresa> update(@RequestBody EmpleadoEmpresa empleadoEmpresa,
                     @PathVariable Long id){
        EmpleadoEmpresa obj = empleadoEmpresaService.save(empleadoEmpresa);
        return ResponseEntity.ok(obj);
    }

    @GetMapping(path="/")
    public @ResponseBody List<EmpleadoEmpresa> all() {
        // This returns a JSON or XML
        return empleadoEmpresaService.list();
    }

    @DeleteMapping(path="/{id}")
    public ResponseEntity<String> deleteById(@PathVariable String id) {
        Long empleadoEmpresaId = Long.parseLong(id);
        if(empleadoEmpresaService.existsById(empleadoEmpresaId)){
            empleadoEmpresaService.deleteById(empleadoEmpresaId);
            return ResponseEntity.ok("Deleted");
        }
        return ResponseEntity.ok("ID not found");
    }
}
