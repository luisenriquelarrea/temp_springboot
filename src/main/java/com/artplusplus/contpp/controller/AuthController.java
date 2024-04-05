package com.artplusplus.contpp.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;

import com.artplusplus.contpp.dto.UsuarioDto;
import com.artplusplus.contpp.dto.AuthResponse;
import com.artplusplus.contpp.dto.LoginRequest;
import com.artplusplus.contpp.service.UsuarioService;

import java.util.Optional;

@Controller // This means that this class is a Controller
@RequestMapping(path="/api") // This means URL's start with /api (after Application path)
public class AuthController {
    private UsuarioService usuarioService;

    @PostMapping(path="/authenticate")
    public ResponseEntity<AuthResponse> login(@Valid @RequestBody LoginRequest loginRequest) {
        Optional<UsuarioDto> userOptional 
            = usuarioService.validUsernameAndPassword(loginRequest.getUsername(), loginRequest.getPassword());
        if (userOptional.isPresent()) {
            UsuarioDto usuarioDto = userOptional.get();
            return ResponseEntity.ok(new AuthResponse(usuarioDto.getId(), usuarioDto.getName()));
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }
}
