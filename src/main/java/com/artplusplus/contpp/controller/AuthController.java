package com.artplusplus.contpp.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;

import lombok.RequiredArgsConstructor;

import com.artplusplus.contpp.model.Usuario;
import com.artplusplus.contpp.dto.AuthResponse;
import com.artplusplus.contpp.dto.LoginRequest;
import com.artplusplus.contpp.service.UsuarioService;

import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController // This means that this class is a Controller
@RequestMapping(path="/api") // This means URL's start with /api (after Application path)
@RequiredArgsConstructor
public class AuthController {
    private final UsuarioService usuarioService;

    @PostMapping(path="/authenticate")
    public ResponseEntity<AuthResponse> login(@Valid @RequestBody LoginRequest loginRequest) {
        Optional<Usuario> userOptional 
            = usuarioService.validUsernameAndPassword(loginRequest.getUsername(), loginRequest.getPassword());
        if (userOptional.isPresent()) {
            Usuario usuario = userOptional.get();
            return ResponseEntity.ok(new AuthResponse(usuario.getGrupo(), usuario.getUsername()));
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }
}
