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

import com.artplusplus.contpp.model.SerieCfdi;
import com.artplusplus.contpp.service.SerieCfdiService;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController // This means that this class is a Controller
@RequestMapping(path="/api/serie_cfdi") // This means URL's start with / (after Application path)
public class SerieCfdiController {
    @Autowired
    private SerieCfdiService serieCfdiService;

    @PostMapping(path="/add") // Map ONLY POST Requests
    public ResponseEntity<SerieCfdi> add(@RequestBody SerieCfdi serieCfdi) {
        // @ResponseBody means the returned Entity is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request
        SerieCfdi obj = serieCfdiService.save(serieCfdi);
        return ResponseEntity.ok(obj);
    }

    @PutMapping(path="/{id}")
    public ResponseEntity<SerieCfdi> update(@RequestBody SerieCfdi serieCfdi,
                     @PathVariable Long id){
        SerieCfdi obj = serieCfdiService.save(serieCfdi);
        return ResponseEntity.ok(obj);
    }

    @GetMapping(path="/")
    public @ResponseBody List<SerieCfdi> all() {
        // This returns a JSON or XML
        return serieCfdiService.list();
    }

    @DeleteMapping(path="/{id}")
    public ResponseEntity<String> deleteById(@PathVariable String id) {
        Long serieCfdiId = Long.parseLong(id);
        if(serieCfdiService.existsById(serieCfdiId)){
            serieCfdiService.deleteById(serieCfdiId);
            return ResponseEntity.ok("Deleted");
        }
        return ResponseEntity.ok("ID not found");
    }
}
