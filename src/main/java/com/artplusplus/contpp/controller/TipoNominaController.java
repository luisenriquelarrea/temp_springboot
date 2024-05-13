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

import com.artplusplus.contpp.model.TipoNomina;
import com.artplusplus.contpp.service.TipoNominaService;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController // This means that this class is a Controller
@RequestMapping(path="/api/tipo_nomina") // This means URL's start with / (after Application path)
public class TipoNominaController {
    @Autowired
    private TipoNominaService tipoNominaService;

    @PostMapping(path="/add") // Map ONLY POST Requests
    public ResponseEntity<TipoNomina> add(@RequestBody TipoNomina tipoNomina) {
        // @ResponseBody means the returned Entity is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request
        TipoNomina obj = tipoNominaService.save(tipoNomina);
        return ResponseEntity.ok(obj);
    }

    @PutMapping(path="/{id}")
    public ResponseEntity<TipoNomina> update(@RequestBody TipoNomina tipoNomina,
                     @PathVariable Long id){
        TipoNomina obj = tipoNominaService.save(tipoNomina);
        return ResponseEntity.ok(obj);
    }

    @GetMapping(path="/")
    public @ResponseBody List<TipoNomina> all() {
        // This returns a JSON or XML
        return tipoNominaService.list();
    }

    @DeleteMapping(path="/{id}")
    public ResponseEntity<String> deleteById(@PathVariable String id) {
        Long tipoNominaId = Long.parseLong(id);
        if(tipoNominaService.existsById(tipoNominaId)){
            tipoNominaService.deleteById(tipoNominaId);
            return ResponseEntity.ok("Deleted");
        }
        return ResponseEntity.ok("ID not found");
    }
}
