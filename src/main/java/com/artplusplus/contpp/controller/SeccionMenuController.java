package com.artplusplus.contpp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.artplusplus.contpp.model.SeccionMenu;
import com.artplusplus.contpp.service.SeccionMenuService;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController // This means that this class is a Controller
@RequestMapping(path="/api/seccion_menu") // This means URL's start with / (after Application path)
public class SeccionMenuController {
    @Autowired private SeccionMenuService seccionMenuService;

    @GetMapping(path="/")
    public @ResponseBody List<SeccionMenu> all() {
        // This returns a JSON or XML with the users
        return seccionMenuService.listSeccionMenu();
    }

    @PostMapping(path="/desc") // Map ONLY POST Requests
    public ResponseEntity<SeccionMenu> getByDesc(@RequestBody SeccionMenu seccionMenu) {
        // @ResponseBody means the returned Entity is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request
        Optional<SeccionMenu> seccionMenuOptional = 
            seccionMenuService.seccionMenuByDescripcion(seccionMenu.getDescripcion());
        if(seccionMenuOptional.isPresent()){
            return ResponseEntity.ok(seccionMenuOptional.get());
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping(path="/{id}")
    public ResponseEntity<SeccionMenu> getById(@PathVariable Long id){
        if(seccionMenuService.getById(id)){
            SeccionMenu seccionMenu = seccionMenuService.seccionMenuById(id);
            return ResponseEntity.ok(seccionMenu);
        }
        return ResponseEntity.notFound().build();
    }
}
