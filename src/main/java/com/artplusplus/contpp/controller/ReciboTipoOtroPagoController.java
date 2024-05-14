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

import com.artplusplus.contpp.model.ReciboTipoOtroPago;
import com.artplusplus.contpp.service.ReciboTipoOtroPagoService;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController // This means that this class is a Controller
@RequestMapping(path="/api/recibo_tipo_otro_pago") // This means URL's start with / (after Application path)
public class ReciboTipoOtroPagoController {
    @Autowired
    private ReciboTipoOtroPagoService reciboTipoOtroPagoService;

    @PostMapping(path="/add") // Map ONLY POST Requests
    public ResponseEntity<ReciboTipoOtroPago> add(@RequestBody ReciboTipoOtroPago reciboTipoOtroPago) {
        // @ResponseBody means the returned Entity is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request
        ReciboTipoOtroPago obj = reciboTipoOtroPagoService.save(reciboTipoOtroPago);
        return ResponseEntity.ok(obj);
    }

    @PutMapping(path="/{id}")
    public ResponseEntity<ReciboTipoOtroPago> update(@RequestBody ReciboTipoOtroPago reciboTipoOtroPago,
                     @PathVariable Long id){
        ReciboTipoOtroPago obj = reciboTipoOtroPagoService.save(reciboTipoOtroPago);
        return ResponseEntity.ok(obj);
    }

    @GetMapping(path="/")
    public @ResponseBody List<ReciboTipoOtroPago> all() {
        // This returns a JSON or XML
        return reciboTipoOtroPagoService.list();
    }

    @DeleteMapping(path="/{id}")
    public ResponseEntity<String> deleteById(@PathVariable String id) {
        Long reciboTipoOtroPagoId = Long.parseLong(id);
        if(reciboTipoOtroPagoService.existsById(reciboTipoOtroPagoId)){
            reciboTipoOtroPagoService.deleteById(reciboTipoOtroPagoId);
            return ResponseEntity.ok("Deleted");
        }
        return ResponseEntity.ok("ID not found");
    }
}
