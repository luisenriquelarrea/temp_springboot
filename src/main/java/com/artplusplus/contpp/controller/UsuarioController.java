package com.artplusplus.contpp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.artplusplus.contpp.model.Usuario;
import com.artplusplus.contpp.service.UsuarioService;

import java.util.List;

@Controller // This means that this class is a Controller
@RequestMapping(path="/api/usuario") // This means URL's start with /Usuario (after Application path)
public class UsuarioController {
    @Autowired private UsuarioService usuarioService;


    @GetMapping(path="/all")
    public @ResponseBody List<Usuario> all() {
        // This returns a JSON or XML with the users
        return usuarioService.listUsuario();
    }

    @GetMapping(path="/{id}")
    public ResponseEntity<Usuario> getById(@PathVariable Long id){
        if(usuarioService.getById(id)){
            Usuario usuario = usuarioService.usuarioById(id);
            return ResponseEntity.ok(usuario);
        }
        return ResponseEntity.notFound().build();
    }
}
