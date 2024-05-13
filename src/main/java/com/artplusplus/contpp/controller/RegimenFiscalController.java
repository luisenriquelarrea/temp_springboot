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

import com.artplusplus.contpp.model.RegimenFiscal;
import com.artplusplus.contpp.service.RegimenFiscalService;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController // This means that this class is a Controller
@RequestMapping(path="/api/regimen_fiscal") // This means URL's start with / (after Application path)
public class RegimenFiscalController {
    @Autowired
    private RegimenFiscalService regimenFiscalService;

    @PostMapping(path="/add") // Map ONLY POST Requests
    public ResponseEntity<RegimenFiscal> add(@RequestBody RegimenFiscal regimenFiscal) {
        // @ResponseBody means the returned Entity is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request
        RegimenFiscal obj = regimenFiscalService.save(regimenFiscal);
        return ResponseEntity.ok(obj);
    }

    @PutMapping(path="/{id}")
    public ResponseEntity<RegimenFiscal> update(@RequestBody RegimenFiscal regimenFiscal,
                     @PathVariable Long id){
        RegimenFiscal obj = regimenFiscalService.save(regimenFiscal);
        return ResponseEntity.ok(obj);
    }

    @GetMapping(path="/")
    public @ResponseBody List<RegimenFiscal> all() {
        // This returns a JSON or XML
        return regimenFiscalService.list();
    }

    @DeleteMapping(path="/{id}")
    public ResponseEntity<String> deleteById(@PathVariable String id) {
        Long regimenFiscalId = Long.parseLong(id);
        if(regimenFiscalService.existsById(regimenFiscalId)){
            regimenFiscalService.deleteById(regimenFiscalId);
            return ResponseEntity.ok("Deleted");
        }
        return ResponseEntity.ok("ID not found");
    }
}
