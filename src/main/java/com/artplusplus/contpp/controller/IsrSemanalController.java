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

import com.artplusplus.contpp.model.IsrSemanal;
import com.artplusplus.contpp.service.IsrSemanalService;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController // This means that this class is a Controller
@RequestMapping(path="/api/isr_semanal") // This means URL's start with / (after Application path)
public class IsrSemanalController {
    @Autowired
    private IsrSemanalService isrSemanalService;

    @PostMapping(path="/add") // Map ONLY POST Requests
    public ResponseEntity<IsrSemanal> add(@RequestBody IsrSemanal isrSemanal) {
        // @ResponseBody means the returned Entity is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request
        IsrSemanal obj = isrSemanalService.save(isrSemanal);
        return ResponseEntity.ok(obj);
    }

    @PutMapping(path="/{id}")
    public ResponseEntity<IsrSemanal> update(@RequestBody IsrSemanal isrSemanal,
                     @PathVariable Long id){
        IsrSemanal obj = isrSemanalService.save(isrSemanal);
        return ResponseEntity.ok(obj);
    }

    @GetMapping(path="/")
    public @ResponseBody List<IsrSemanal> all() {
        // This returns a JSON or XML
        return isrSemanalService.list();
    }

    @DeleteMapping(path="/{id}")
    public ResponseEntity<String> deleteById(@PathVariable String id) {
        Long isrSemanalId = Long.parseLong(id);
        if(isrSemanalService.existsById(isrSemanalId)){
            isrSemanalService.deleteById(isrSemanalId);
            return ResponseEntity.ok("Deleted");
        }
        return ResponseEntity.ok("ID not found");
    }
}
