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

import com.artplusplus.contpp.model.DivisionProducto;
import com.artplusplus.contpp.service.DivisionProductoService;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController // This means that this class is a Controller
@RequestMapping(path="/api/division_producto") // This means URL's start with / (after Application path)
public class DivisionProductoController {
    @Autowired
    private DivisionProductoService divisionProductoService;

    @PostMapping(path="/add") // Map ONLY POST Requests
    public ResponseEntity<DivisionProducto> add(@RequestBody DivisionProducto divisionProducto) {
        // @ResponseBody means the returned Entity is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request
        DivisionProducto obj = divisionProductoService.save(divisionProducto);
        return ResponseEntity.ok(obj);
    }

    @PutMapping(path="/{id}")
    public ResponseEntity<DivisionProducto> update(@RequestBody DivisionProducto divisionProducto,
                     @PathVariable Long id){
        DivisionProducto obj = divisionProductoService.save(divisionProducto);
        return ResponseEntity.ok(obj);
    }

    @GetMapping(path="/")
    public @ResponseBody List<DivisionProducto> all() {
        // This returns a JSON or XML
        return divisionProductoService.list();
    }

    @DeleteMapping(path="/{id}")
    public ResponseEntity<String> deleteById(@PathVariable String id) {
        Long divisionProductoId = Long.parseLong(id);
        if(divisionProductoService.existsById(divisionProductoId)){
            divisionProductoService.deleteById(divisionProductoId);
            return ResponseEntity.ok("Deleted");
        }
        return ResponseEntity.ok("ID not found");
    }
}
