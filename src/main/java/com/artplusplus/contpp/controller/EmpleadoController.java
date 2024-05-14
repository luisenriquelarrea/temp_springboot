package com.artplusplus.contpp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
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

import com.artplusplus.contpp.model.Empleado;
import com.artplusplus.contpp.service.EmpleadoService;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController // This means that this class is a Controller
@RequestMapping(path="/api/empleado") // This means URL's start with /empleado (after Application path)
public class EmpleadoController {
    @Autowired private EmpleadoService empleadoService;

    @PostMapping(path="/add") // Map ONLY POST Requests
    public ResponseEntity<Empleado> add(@RequestBody Empleado empleado) {
        // @ResponseBody means the returned Entity is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request
        Empleado obj = empleadoService.save(empleado);
        try{
            obj.getId();
        }catch(DataAccessException ex){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        return ResponseEntity.ok(obj);
    }

    @GetMapping(path="/")
    public @ResponseBody List<Empleado> all() {
        // This returns a JSON or XML with the users
        return empleadoService.list();
    }

    @PutMapping(path="/{id}")
    public ResponseEntity<Empleado> update(@RequestBody Empleado empleado,
                     @PathVariable Long id){
        Empleado obj = empleadoService.save(empleado);
        return ResponseEntity.ok(obj);
    }

    @DeleteMapping(path="/{id}")
    public ResponseEntity<String> deleteById(@PathVariable String id) {
        Long empleadoId = Long.parseLong(id);
        if(empleadoService.existsById(empleadoId)){
            empleadoService.deleteById(empleadoId);
            return ResponseEntity.ok("Deleted");
        }
        return ResponseEntity.ok("ID not found");
    }

    @GetMapping(path="/{id}")
    public ResponseEntity<Empleado> getById(@PathVariable Long id){
        if(empleadoService.existsById(id)){
            Empleado empleado = empleadoService.getById(id);
            return ResponseEntity.ok(empleado);
        }
        return ResponseEntity.notFound().build();
    }
}
