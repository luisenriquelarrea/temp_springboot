package com.artplusplus.contpp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.artplusplus.contpp.model.Usuario;
import com.artplusplus.contpp.dto.UsuarioDto;
import com.artplusplus.contpp.service.UsuarioService;

@Controller // This means that this class is a Controller
@RequestMapping(path="/api/usuario") // This means URL's start with /Usuario (after Application path)
public class UsuarioController {
    @Autowired 
    private UsuarioService usuarioService;

    @PostMapping(path="/add") // Map ONLY POST Requests
    public ResponseEntity<UsuarioDto> add(@RequestBody Usuario usuario) {
        // @ResponseBody means the returned Entity is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request
        UsuarioDto obj = usuarioService.save(usuario);
        return ResponseEntity.ok(obj);
    }

    @PutMapping(path="/{id}")
    public ResponseEntity<UsuarioDto> update(@RequestBody Usuario usuario,
                     @PathVariable Long id){
        UsuarioDto obj = usuarioService.save(usuario);
        return ResponseEntity.ok(obj);
    }

    @DeleteMapping(path="/{id}")
    public ResponseEntity<String> deleteById(@PathVariable String id) {
        Long usuarioId = Long.parseLong(id);
        if(usuarioService.existsById(usuarioId)){
            usuarioService.deleteById(usuarioId);
            return ResponseEntity.ok("Deleted");
        }
        return ResponseEntity.ok("ID not found");
    }

    @GetMapping(path="/{id}")
    public ResponseEntity<UsuarioDto> getById(@PathVariable Long id){
        if(usuarioService.existsById(id)){
            UsuarioDto usuario = usuarioService.getById(id);
            return ResponseEntity.ok(usuario);
        }
        return ResponseEntity.notFound().build();
    }
}
