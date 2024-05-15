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

import com.artplusplus.contpp.model.ContratoLaboral;
import com.artplusplus.contpp.service.ContratoLaboralService;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController // This means that this class is a Controller
@RequestMapping(path="/api/contrato_laboral") // This means URL's start with / (after Application path)
public class ContratoLaboralController {
    @Autowired
    private ContratoLaboralService contratoLaboralService;

    @PostMapping(path="/add") // Map ONLY POST Requests
    public ResponseEntity<ContratoLaboral> add(@RequestBody ContratoLaboral contratoLaboral) {
        // @ResponseBody means the returned Entity is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request
        ContratoLaboral obj = contratoLaboralService.save(contratoLaboral);
        return ResponseEntity.ok(obj);
    }

    @PutMapping(path="/{id}")
    public ResponseEntity<ContratoLaboral> update(@RequestBody ContratoLaboral contratoLaboral,
                     @PathVariable Long id){
        ContratoLaboral obj = contratoLaboralService.save(contratoLaboral);
        return ResponseEntity.ok(obj);
    }

    @GetMapping(path="/")
    public @ResponseBody List<ContratoLaboral> all() {
        // This returns a JSON or XML
        return contratoLaboralService.list();
    }

    @DeleteMapping(path="/{id}")
    public ResponseEntity<String> deleteById(@PathVariable String id) {
        Long contratoLaboralId = Long.parseLong(id);
        if(contratoLaboralService.existsById(contratoLaboralId)){
            contratoLaboralService.deleteById(contratoLaboralId);
            return ResponseEntity.ok("Deleted");
        }
        return ResponseEntity.ok("ID not found");
    }
}
