package com.artplusplus.contpp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.artplusplus.contpp.model.Usuario;
import com.artplusplus.contpp.dto.UsuarioDto;
import com.artplusplus.contpp.service.UsuarioService;
import com.artplusplus.contpp.repository.specifications.UsuarioSpecifications;

import java.util.List;

@Controller // This means that this class is a Controller
@RequestMapping(path="/api/usuario") // This means URL's start with /Usuario (after Application path)
public class UsuarioController {
    @Autowired 
    private UsuarioService usuarioService;

    /*@PostMapping(path="/add") // Map ONLY POST Requests
    public ResponseEntity<Usuario> add(@RequestBody Usuario usuario) {
        // @ResponseBody means the returned Entity is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request
        Usuario obj = usuarioService.save(usuario);
        return ResponseEntity.ok(obj);
    }*/

    @PutMapping(path="/{id}")
    public ResponseEntity<Usuario> update(@RequestBody Usuario usuario,
                     @PathVariable Long id){
        Usuario obj = usuarioService.save(usuario);
        return ResponseEntity.ok(obj);
    }

    /*@GetMapping(path="/")
    public @ResponseBody List<Usuario> all() {
        // This returns a JSON or XML
        return usuarioService.list();
    }*/

    /*@DeleteMapping(path="/{id}")
    public ResponseEntity<String> deleteById(@PathVariable String id) {
        Long usuarioId = Long.parseLong(id);
        if(usuarioService.existsById(usuarioId)){
            usuarioService.deleteById(usuarioId);
            return ResponseEntity.ok("Deleted");
        }
        return ResponseEntity.ok("ID not found");
    }*/

    @GetMapping(path="/{id}")
    public ResponseEntity<Usuario> getById(@PathVariable Long id){
        if(usuarioService.existsById(id)){
            Usuario usuario = usuarioService.getById(id);
            return ResponseEntity.ok(usuario);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping(path="/filteredList") // Map ONLY POST Requests
    public @ResponseBody List<UsuarioDto> filteredList(@RequestBody UsuarioDto usuarioDto) {
        // @ResponseBody means the returned Entity is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request
        Specification<Usuario> specs = new UsuarioSpecifications(usuarioDto);
        return usuarioService.filteredList(specs);
    }
}
