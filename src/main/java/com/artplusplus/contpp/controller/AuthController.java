package com.artplusplus.contpp.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;

import lombok.RequiredArgsConstructor;

import com.artplusplus.contpp.model.Usuario;
import com.artplusplus.contpp.dto.UsuarioDto;
import com.artplusplus.contpp.dto.AuthResponse;
import com.artplusplus.contpp.dto.LoginRequest;
import com.artplusplus.contpp.service.UsuarioService;

import java.util.Optional;

@Controller // This means that this class is a Controller
@RequestMapping(path="/api") // This means URL's start with /api (after Application path)
@RequiredArgsConstructor
public class AuthController {
    private final UsuarioService usuarioService;

    @PostMapping(path="/authenticate")
    public ResponseEntity<AuthResponse> login(@Valid @RequestBody LoginRequest loginRequest) {
        Optional<Usuario> userOptional 
            = usuarioService.validUsernameAndPassword(loginRequest.getName(), loginRequest.getPassword());
        if (userOptional.isPresent()) {
            Usuario usuario = userOptional.get();
            return ResponseEntity.ok(new AuthResponse(usuario.getId(), usuario.getName()));
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }
}
