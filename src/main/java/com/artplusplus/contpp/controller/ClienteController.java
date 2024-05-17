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

import com.artplusplus.contpp.model.Cliente;
import com.artplusplus.contpp.service.ClienteService;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController // This means that this class is a Controller
@RequestMapping(path="/api/cliente") // This means URL's start with / (after Application path)
public class ClienteController {
    @Autowired
    private ClienteService clienteService;

    @PostMapping(path="/add") // Map ONLY POST Requests
    public ResponseEntity<Cliente> add(@RequestBody Cliente cliente) {
        // @ResponseBody means the returned Entity is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request
        Cliente obj = clienteService.save(cliente);
        return ResponseEntity.ok(obj);
    }

    @PutMapping(path="/{id}")
    public ResponseEntity<Cliente> update(@RequestBody Cliente cliente,
                     @PathVariable Long id){
        Cliente obj = clienteService.save(cliente);
        return ResponseEntity.ok(obj);
    }

    @GetMapping(path="/")
    public @ResponseBody List<Cliente> all() {
        // This returns a JSON or XML
        return clienteService.list();
    }

    @DeleteMapping(path="/{id}")
    public ResponseEntity<String> deleteById(@PathVariable String id) {
        Long clienteId = Long.parseLong(id);
        if(clienteService.existsById(clienteId)){
            clienteService.deleteById(clienteId);
            return ResponseEntity.ok("Deleted");
        }
        return ResponseEntity.ok("ID not found");
    }
}
