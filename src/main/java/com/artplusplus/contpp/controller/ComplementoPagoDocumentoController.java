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

import com.artplusplus.contpp.model.ComplementoPagoDocumento;
import com.artplusplus.contpp.service.ComplementoPagoDocumentoService;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController // This means that this class is a Controller
@RequestMapping(path="/api/complemento_pago_documento") // This means URL's start with / (after Application path)
public class ComplementoPagoDocumentoController {
    @Autowired
    private ComplementoPagoDocumentoService complementoPagoDocumentoService;

    @PostMapping(path="/add") // Map ONLY POST Requests
    public ResponseEntity<ComplementoPagoDocumento> add(@RequestBody ComplementoPagoDocumento complementoPagoDocumento) {
        // @ResponseBody means the returned Entity is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request
        ComplementoPagoDocumento obj = complementoPagoDocumentoService.save(complementoPagoDocumento);
        return ResponseEntity.ok(obj);
    }

    @PutMapping(path="/{id}")
    public ResponseEntity<ComplementoPagoDocumento> update(@RequestBody ComplementoPagoDocumento complementoPagoDocumento,
                     @PathVariable Long id){
        ComplementoPagoDocumento obj = complementoPagoDocumentoService.save(complementoPagoDocumento);
        return ResponseEntity.ok(obj);
    }

    @GetMapping(path="/")
    public @ResponseBody List<ComplementoPagoDocumento> all() {
        // This returns a JSON or XML
        return complementoPagoDocumentoService.list();
    }

    @DeleteMapping(path="/{id}")
    public ResponseEntity<String> deleteById(@PathVariable String id) {
        Long complementoPagoDocumentoId = Long.parseLong(id);
        if(complementoPagoDocumentoService.existsById(complementoPagoDocumentoId)){
            complementoPagoDocumentoService.deleteById(complementoPagoDocumentoId);
            return ResponseEntity.ok("Deleted");
        }
        return ResponseEntity.ok("ID not found");
    }
}
