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

import com.artplusplus.contpp.model.TipoPercepcion;
import com.artplusplus.contpp.service.TipoPercepcionService;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController // This means that this class is a Controller
@RequestMapping(path="/api/tipo_percepcion") // This means URL's start with / (after Application path)
public class TipoPercepcionController {
    @Autowired
    private TipoPercepcionService tipoPercepcionService;

    @PostMapping(path="/add") // Map ONLY POST Requests
    public ResponseEntity<TipoPercepcion> add(@RequestBody TipoPercepcion tipoPercepcion) {
        // @ResponseBody means the returned Entity is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request
        TipoPercepcion obj = tipoPercepcionService.save(tipoPercepcion);
        return ResponseEntity.ok(obj);
    }

    @PutMapping(path="/{id}")
    public ResponseEntity<TipoPercepcion> update(@RequestBody TipoPercepcion tipoPercepcion,
                     @PathVariable Long id){
        TipoPercepcion obj = tipoPercepcionService.save(tipoPercepcion);
        return ResponseEntity.ok(obj);
    }

    @GetMapping(path="/")
    public @ResponseBody List<TipoPercepcion> all() {
        // This returns a JSON or XML
        return tipoPercepcionService.list();
    }

    @DeleteMapping(path="/{id}")
    public ResponseEntity<String> deleteById(@PathVariable String id) {
        Long tipoPercepcionId = Long.parseLong(id);
        if(tipoPercepcionService.existsById(tipoPercepcionId)){
            tipoPercepcionService.deleteById(tipoPercepcionId);
            return ResponseEntity.ok("Deleted");
        }
        return ResponseEntity.ok("ID not found");
    }
}
