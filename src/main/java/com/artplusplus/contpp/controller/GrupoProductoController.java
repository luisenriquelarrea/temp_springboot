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

import com.artplusplus.contpp.model.GrupoProducto;
import com.artplusplus.contpp.service.GrupoProductoService;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController // This means that this class is a Controller
@RequestMapping(path="/api/grupo_producto") // This means URL's start with / (after Application path)
public class GrupoProductoController {
    @Autowired
    private GrupoProductoService grupoProductoService;

    @PostMapping(path="/add") // Map ONLY POST Requests
    public ResponseEntity<GrupoProducto> add(@RequestBody GrupoProducto grupoProducto) {
        // @ResponseBody means the returned Entity is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request
        GrupoProducto obj = grupoProductoService.save(grupoProducto);
        return ResponseEntity.ok(obj);
    }

    @PutMapping(path="/{id}")
    public ResponseEntity<GrupoProducto> update(@RequestBody GrupoProducto grupoProducto,
                     @PathVariable Long id){
        GrupoProducto obj = grupoProductoService.save(grupoProducto);
        return ResponseEntity.ok(obj);
    }

    @GetMapping(path="/")
    public @ResponseBody List<GrupoProducto> all() {
        // This returns a JSON or XML
        return grupoProductoService.list();
    }

    @DeleteMapping(path="/{id}")
    public ResponseEntity<String> deleteById(@PathVariable String id) {
        Long grupoProductoId = Long.parseLong(id);
        if(grupoProductoService.existsById(grupoProductoId)){
            grupoProductoService.deleteById(grupoProductoId);
            return ResponseEntity.ok("Deleted");
        }
        return ResponseEntity.ok("ID not found");
    }
}
