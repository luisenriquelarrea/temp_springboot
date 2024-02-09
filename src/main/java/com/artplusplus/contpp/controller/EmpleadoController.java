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

import com.artplusplus.contpp.model.Empleado;
import com.artplusplus.contpp.service.EmpleadoService;

import java.util.List;

@Controller // This means that this class is a Controller
@RequestMapping(path="/empleado") // This means URL's start with /empleado (after Application path)
public class EmpleadoController {
    @Autowired private EmpleadoService empleadoService;

    @PostMapping(path="/add") // Map ONLY POST Requests
    public ResponseEntity<Empleado> add(@RequestBody Empleado empleado) {
        // @ResponseBody means the returned Entity is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request
        Empleado newEmpleado = empleadoService.saveEmpleado(empleado);
        return ResponseEntity.ok(newEmpleado);
    }

    @GetMapping(path="/all")
    public @ResponseBody List<Empleado> all() {
        // This returns a JSON or XML with the users
        return empleadoService.listEmpleado();
    }

    @PutMapping(path="/{id}")
    public ResponseEntity<Empleado> update(@RequestBody Empleado empleado,
                     @PathVariable Long id){
        Empleado updEmpleado = empleadoService.updateEmpleado(empleado, id);
        return ResponseEntity.ok(updEmpleado);
    }

    @DeleteMapping(path="/{id}")
    public ResponseEntity<String> delete(@PathVariable String id) {
        Long empleadoId = Long.parseLong(id);
        if(empleadoService.getById(empleadoId)){
            empleadoService.deleteEmpleado(empleadoId);
            return ResponseEntity.ok("Deleted");
        }
        return ResponseEntity.ok("ID not found");
    }
}
