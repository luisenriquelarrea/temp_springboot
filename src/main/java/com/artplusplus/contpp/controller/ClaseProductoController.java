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

import com.artplusplus.contpp.model.ClaseProducto;
import com.artplusplus.contpp.service.ClaseProductoService;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController // This means that this class is a Controller
@RequestMapping(path="/api/clase_producto") // This means URL's start with / (after Application path)
public class ClaseProductoController {
    @Autowired
    private ClaseProductoService claseProductoService;

    @PostMapping(path="/add") // Map ONLY POST Requests
    public ResponseEntity<ClaseProducto> add(@RequestBody ClaseProducto claseProducto) {
        // @ResponseBody means the returned Entity is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request
        ClaseProducto obj = claseProductoService.save(claseProducto);
        return ResponseEntity.ok(obj);
    }

    @PutMapping(path="/{id}")
    public ResponseEntity<ClaseProducto> update(@RequestBody ClaseProducto claseProducto,
                     @PathVariable Long id){
        ClaseProducto obj = claseProductoService.save(claseProducto);
        return ResponseEntity.ok(obj);
    }

    @GetMapping(path="/")
    public @ResponseBody List<ClaseProducto> all() {
        // This returns a JSON or XML
        return claseProductoService.list();
    }

    @DeleteMapping(path="/{id}")
    public ResponseEntity<String> deleteById(@PathVariable String id) {
        Long claseProductoId = Long.parseLong(id);
        if(claseProductoService.existsById(claseProductoId)){
            claseProductoService.deleteById(claseProductoId);
            return ResponseEntity.ok("Deleted");
        }
        return ResponseEntity.ok("ID not found");
    }
}
