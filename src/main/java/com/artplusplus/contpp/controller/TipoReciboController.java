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

import com.artplusplus.contpp.model.TipoRecibo;
import com.artplusplus.contpp.service.TipoReciboService;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController // This means that this class is a Controller
@RequestMapping(path="/api/tipo_recibo") // This means URL's start with / (after Application path)
public class TipoReciboController {
    @Autowired
    private TipoReciboService tipoReciboService;

    @PostMapping(path="/add") // Map ONLY POST Requests
    public ResponseEntity<TipoRecibo> add(@RequestBody TipoRecibo tipoRecibo) {
        // @ResponseBody means the returned Entity is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request
        TipoRecibo obj = tipoReciboService.save(tipoRecibo);
        return ResponseEntity.ok(obj);
    }

    @PutMapping(path="/{id}")
    public ResponseEntity<TipoRecibo> update(@RequestBody TipoRecibo tipoRecibo,
                     @PathVariable Long id){
        TipoRecibo obj = tipoReciboService.save(tipoRecibo);
        return ResponseEntity.ok(obj);
    }

    @GetMapping(path="/")
    public @ResponseBody List<TipoRecibo> all() {
        // This returns a JSON or XML
        return tipoReciboService.list();
    }

    @DeleteMapping(path="/{id}")
    public ResponseEntity<String> deleteById(@PathVariable String id) {
        Long tipoReciboId = Long.parseLong(id);
        if(tipoReciboService.existsById(tipoReciboId)){
            tipoReciboService.deleteById(tipoReciboId);
            return ResponseEntity.ok("Deleted");
        }
        return ResponseEntity.ok("ID not found");
    }
}
