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

import com.artplusplus.contpp.model.UsoCfdi;
import com.artplusplus.contpp.service.UsoCfdiService;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController // This means that this class is a Controller
@RequestMapping(path="/api/uso_cfdi") // This means URL's start with / (after Application path)
public class UsoCfdiController {
    @Autowired
    private UsoCfdiService usoCfdiService;

    @PostMapping(path="/add") // Map ONLY POST Requests
    public ResponseEntity<UsoCfdi> add(@RequestBody UsoCfdi usoCfdi) {
        // @ResponseBody means the returned Entity is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request
        UsoCfdi obj = usoCfdiService.save(usoCfdi);
        return ResponseEntity.ok(obj);
    }

    @PutMapping(path="/{id}")
    public ResponseEntity<UsoCfdi> update(@RequestBody UsoCfdi usoCfdi,
                     @PathVariable Long id){
        UsoCfdi obj = usoCfdiService.save(usoCfdi);
        return ResponseEntity.ok(obj);
    }

    @GetMapping(path="/")
    public @ResponseBody List<UsoCfdi> all() {
        // This returns a JSON or XML
        return usoCfdiService.list();
    }

    @DeleteMapping(path="/{id}")
    public ResponseEntity<String> deleteById(@PathVariable String id) {
        Long usoCfdiId = Long.parseLong(id);
        if(usoCfdiService.existsById(usoCfdiId)){
            usoCfdiService.deleteById(usoCfdiId);
            return ResponseEntity.ok("Deleted");
        }
        return ResponseEntity.ok("ID not found");
    }
}
