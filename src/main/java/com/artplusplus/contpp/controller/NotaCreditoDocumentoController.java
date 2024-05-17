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

import com.artplusplus.contpp.model.NotaCreditoDocumento;
import com.artplusplus.contpp.service.NotaCreditoDocumentoService;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController // This means that this class is a Controller
@RequestMapping(path="/api/NotaCreditoDocumento") // This means URL's start with / (after Application path)
public class NotaCreditoDocumentoController {
    @Autowired
    private NotaCreditoDocumentoService notaCreditoDocumentoService;

    @PostMapping(path="/add") // Map ONLY POST Requests
    public ResponseEntity<NotaCreditoDocumento> add(@RequestBody NotaCreditoDocumento notaCreditoDocumento) {
        // @ResponseBody means the returned Entity is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request
        NotaCreditoDocumento obj = notaCreditoDocumentoService.save(notaCreditoDocumento);
        return ResponseEntity.ok(obj);
    }

    @PutMapping(path="/{id}")
    public ResponseEntity<NotaCreditoDocumento> update(@RequestBody NotaCreditoDocumento notaCreditoDocumento,
                     @PathVariable Long id){
        NotaCreditoDocumento obj = notaCreditoDocumentoService.save(notaCreditoDocumento);
        return ResponseEntity.ok(obj);
    }

    @GetMapping(path="/")
    public @ResponseBody List<NotaCreditoDocumento> all() {
        // This returns a JSON or XML
        return notaCreditoDocumentoService.list();
    }

    @DeleteMapping(path="/{id}")
    public ResponseEntity<String> deleteById(@PathVariable String id) {
        Long notaCreditoDocumentoId = Long.parseLong(id);
        if(notaCreditoDocumentoService.existsById(notaCreditoDocumentoId)){
            notaCreditoDocumentoService.deleteById(notaCreditoDocumentoId);
            return ResponseEntity.ok("Deleted");
        }
        return ResponseEntity.ok("ID not found");
    }
}
