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

import com.artplusplus.contpp.model.TipoProducto;
import com.artplusplus.contpp.service.TipoProductoService;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController // This means that this class is a Controller
@RequestMapping(path="/api/tipo_producto") // This means URL's start with / (after Application path)
public class TipoProductoController {
    @Autowired
    private TipoProductoService tipoProductoService;

    @PostMapping(path="/add") // Map ONLY POST Requests
    public ResponseEntity<TipoProducto> add(@RequestBody TipoProducto tipoProducto) {
        // @ResponseBody means the returned Entity is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request
        TipoProducto obj = tipoProductoService.save(tipoProducto);
        return ResponseEntity.ok(obj);
    }

    @PutMapping(path="/{id}")
    public ResponseEntity<TipoProducto> update(@RequestBody TipoProducto tipoProducto,
                     @PathVariable Long id){
        TipoProducto obj = tipoProductoService.save(tipoProducto);
        return ResponseEntity.ok(obj);
    }

    @GetMapping(path="/")
    public @ResponseBody List<TipoProducto> all() {
        // This returns a JSON or XML
        return tipoProductoService.list();
    }

    @DeleteMapping(path="/{id}")
    public ResponseEntity<String> deleteById(@PathVariable String id) {
        Long tipoProductoId = Long.parseLong(id);
        if(tipoProductoService.existsById(tipoProductoId)){
            tipoProductoService.deleteById(tipoProductoId);
            return ResponseEntity.ok("Deleted");
        }
        return ResponseEntity.ok("ID not found");
    }
}
