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

import com.artplusplus.contpp.model.AccionBasica;
import com.artplusplus.contpp.service.AccionBasicaService;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController // This means that this class is a Controller
@RequestMapping(path="/api/accion_basica") // This means URL's start with / (after Application path)
public class AccionBasicaController {
    @Autowired 
    private AccionBasicaService accionBasicaService;

    @PostMapping(path="/add") // Map ONLY POST Requests
    public ResponseEntity<AccionBasica> add(@RequestBody AccionBasica accionBasica) {
        // @ResponseBody means the returned Entity is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request
        AccionBasica obj = accionBasicaService.save(accionBasica);
        return ResponseEntity.ok(obj);
    }

    @PutMapping(path="/{id}")
    public ResponseEntity<AccionBasica> update(@RequestBody AccionBasica accionBasica,
                     @PathVariable Long id){
        AccionBasica obj = accionBasicaService.save(accionBasica);
        return ResponseEntity.ok(obj);
    }

    @GetMapping(path="/")
    public @ResponseBody List<AccionBasica> all() {
        // This returns a JSON or XML with the users
        return accionBasicaService.list();
    }

    @DeleteMapping(path="/{id}")
    public ResponseEntity<String> deleteById(@PathVariable String id) {
        Long accionBasicaId = Long.parseLong(id);
        if(accionBasicaService.existsById(accionBasicaId)){
            accionBasicaService.deleteById(accionBasicaId);
            return ResponseEntity.ok("Deleted");
        }
        return ResponseEntity.ok("ID not found");
    }
}
