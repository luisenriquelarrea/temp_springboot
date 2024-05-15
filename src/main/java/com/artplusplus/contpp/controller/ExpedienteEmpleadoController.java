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

import com.artplusplus.contpp.model.ExpedienteEmpleado;
import com.artplusplus.contpp.service.ExpedienteEmpleadoService;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController // This means that this class is a Controller
@RequestMapping(path="/api/expediente_empleado") // This means URL's start with / (after Application path)
public class ExpedienteEmpleadoController {
    @Autowired
    private ExpedienteEmpleadoService expedienteEmpleadoService;

    @PostMapping(path="/add") // Map ONLY POST Requests
    public ResponseEntity<ExpedienteEmpleado> add(@RequestBody ExpedienteEmpleado expedienteEmpleado) {
        // @ResponseBody means the returned Entity is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request
        ExpedienteEmpleado obj = expedienteEmpleadoService.save(expedienteEmpleado);
        return ResponseEntity.ok(obj);
    }

    @PutMapping(path="/{id}")
    public ResponseEntity<ExpedienteEmpleado> update(@RequestBody ExpedienteEmpleado expedienteEmpleado,
                     @PathVariable Long id){
        ExpedienteEmpleado obj = expedienteEmpleadoService.save(expedienteEmpleado);
        return ResponseEntity.ok(obj);
    }

    @GetMapping(path="/")
    public @ResponseBody List<ExpedienteEmpleado> all() {
        // This returns a JSON or XML
        return expedienteEmpleadoService.list();
    }

    @DeleteMapping(path="/{id}")
    public ResponseEntity<String> deleteById(@PathVariable String id) {
        Long expedienteEmpleadoId = Long.parseLong(id);
        if(expedienteEmpleadoService.existsById(expedienteEmpleadoId)){
            expedienteEmpleadoService.deleteById(expedienteEmpleadoId);
            return ResponseEntity.ok("Deleted");
        }
        return ResponseEntity.ok("ID not found");
    }
}
