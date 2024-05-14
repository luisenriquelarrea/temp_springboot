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

import com.artplusplus.contpp.model.Recibo;
import com.artplusplus.contpp.service.ReciboService;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController // This means that this class is a Controller
@RequestMapping(path="/api/recibo") // This means URL's start with / (after Application path)
public class ReciboController {
    @Autowired
    private ReciboService reciboService;

    @PostMapping(path="/add") // Map ONLY POST Requests
    public ResponseEntity<Recibo> add(@RequestBody Recibo recibo) {
        // @ResponseBody means the returned Entity is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request
        Recibo obj = reciboService.save(recibo);
        return ResponseEntity.ok(obj);
    }

    @PutMapping(path="/{id}")
    public ResponseEntity<Recibo> update(@RequestBody Recibo recibo,
                     @PathVariable Long id){
        Recibo obj = reciboService.save(recibo);
        return ResponseEntity.ok(obj);
    }

    @GetMapping(path="/")
    public @ResponseBody List<Recibo> all() {
        // This returns a JSON or XML
        return reciboService.list();
    }

    @DeleteMapping(path="/{id}")
    public ResponseEntity<String> deleteById(@PathVariable String id) {
        Long reciboId = Long.parseLong(id);
        if(reciboService.existsById(reciboId)){
            reciboService.deleteById(reciboId);
            return ResponseEntity.ok("Deleted");
        }
        return ResponseEntity.ok("ID not found");
    }
}
