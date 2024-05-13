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

import com.artplusplus.contpp.model.TipoOtroPago;
import com.artplusplus.contpp.service.TipoOtroPagoService;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController // This means that this class is a Controller
@RequestMapping(path="/api/tipo_otro_pago") // This means URL's start with / (after Application path)
public class TipoOtroPagoController {
    @Autowired
    private TipoOtroPagoService tipoOtroPagoService;

    @PostMapping(path="/add") // Map ONLY POST Requests
    public ResponseEntity<TipoOtroPago> add(@RequestBody TipoOtroPago tipoOtroPago) {
        // @ResponseBody means the returned Entity is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request
        TipoOtroPago obj = tipoOtroPagoService.save(tipoOtroPago);
        return ResponseEntity.ok(obj);
    }

    @PutMapping(path="/{id}")
    public ResponseEntity<TipoOtroPago> update(@RequestBody TipoOtroPago tipoOtroPago,
                     @PathVariable Long id){
        TipoOtroPago obj = tipoOtroPagoService.save(tipoOtroPago);
        return ResponseEntity.ok(obj);
    }

    @GetMapping(path="/")
    public @ResponseBody List<TipoOtroPago> all() {
        // This returns a JSON or XML
        return tipoOtroPagoService.list();
    }

    @DeleteMapping(path="/{id}")
    public ResponseEntity<String> deleteById(@PathVariable String id) {
        Long tipoOtroPagoId = Long.parseLong(id);
        if(tipoOtroPagoService.existsById(tipoOtroPagoId)){
            tipoOtroPagoService.deleteById(tipoOtroPagoId);
            return ResponseEntity.ok("Deleted");
        }
        return ResponseEntity.ok("ID not found");
    }
}
