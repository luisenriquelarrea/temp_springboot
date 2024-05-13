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

import com.artplusplus.contpp.model.AltaBajaImss;
import com.artplusplus.contpp.service.AltaBajaImssService;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController // This means that this class is a Controller
@RequestMapping(path="/api/alta_baja_imss") // This means URL's start with / (after Application path)
public class AltaBajaImssController {
    @Autowired
    private AltaBajaImssService altaBajaImssService;

    @PostMapping(path="/add") // Map ONLY POST Requests
    public ResponseEntity<AltaBajaImss> add(@RequestBody AltaBajaImss altaBajaImss) {
        // @ResponseBody means the returned Entity is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request
        AltaBajaImss obj = altaBajaImssService.save(altaBajaImss);
        return ResponseEntity.ok(obj);
    }

    @PutMapping(path="/{id}")
    public ResponseEntity<AltaBajaImss> update(@RequestBody AltaBajaImss altaBajaImss,
                     @PathVariable Long id){
        AltaBajaImss obj = altaBajaImssService.save(altaBajaImss);
        return ResponseEntity.ok(obj);
    }

    @GetMapping(path="/")
    public @ResponseBody List<AltaBajaImss> all() {
        // This returns a JSON or XML
        return altaBajaImssService.list();
    }

    @DeleteMapping(path="/{id}")
    public ResponseEntity<String> deleteById(@PathVariable String id) {
        Long altaBajaImssId = Long.parseLong(id);
        if(altaBajaImssService.existsById(altaBajaImssId)){
            altaBajaImssService.deleteById(altaBajaImssId);
            return ResponseEntity.ok("Deleted");
        }
        return ResponseEntity.ok("ID not found");
    }
}
